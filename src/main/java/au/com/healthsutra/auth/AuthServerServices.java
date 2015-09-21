package au.com.healthsutra.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class AuthServerServices {

    private static final Logger LOG = LoggerFactory.getLogger(AuthServerServices.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${restapi.retrieveuser}")
    private String retrieveUserRestAPI;

    @Value("${restapi.retrievetoken}")
    private String retrieveAccessTokenRestAPI;


    public String retrieveUserViaOAuthToken(final String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        HttpEntity<String> stringHttpEntity = new HttpEntity<String>(headers);
        try {
            trustSelfSignedSSL();
            return restTemplate.postForObject(retrieveUserRestAPI, stringHttpEntity, String.class);
        } catch (HttpClientErrorException ex) {
            throw new AuthenticationServiceException("Auth Server Error", ex);
        }
    }

    public String retrieveAccessToken(final String username, final String password, final String authorizationHeader) {
        Assert.isTrue(!isAnyEmpty(username, password, authorizationHeader), "Username/Password/AuthorizationHeader cannot be EMPTY or NULL");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "password");
        map.add("username", username);
        map.add("password", password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "Basic "+authorizationHeader);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        try {
            trustSelfSignedSSL();
            return restTemplate.postForObject(retrieveAccessTokenRestAPI, request, String.class);
        } catch (HttpClientErrorException ex) {
            throw new AuthenticationServiceException("Auth Server Error", ex);
        } catch (Exception e) {
            throw new AuthenticationServiceException("User Account is Locked in LDAP / VDS ", e);
        }

    }

    private static void trustSelfSignedSSL() {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                public void checkClientTrusted(final java.security.cert.X509Certificate[] x509Certificates, final String s) throws java.security.cert.CertificateException {
                }

                public void checkServerTrusted(final java.security.cert.X509Certificate[] x509Certificates, final String s) throws java.security.cert.CertificateException {
                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLContext.setDefault(ctx);
        } catch (Exception ex) {
            LOG.error("Error : {}", ex);
        }
    }

    private boolean isAnyEmpty(String userName, String password, String authorizationHeader) {
        return (userName == null || userName.isEmpty() || password == null || password.isEmpty() || authorizationHeader == null || authorizationHeader.isEmpty());
    }
}
