package au.com.healthsutra.auth;

import au.com.healthsutra.dao.HSUser;
import flexjson.JSONDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Map;

public class HSAuthenticationProvider implements AuthenticationProvider, Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(HSAuthenticationProvider.class);

    @Autowired
    private AuthServerServices authServerServices;

    private String authenticationHeader;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication);

        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new BadCredentialsException("Username or Password is Invalid");
        }

        final String oauthTokenResponse = authServerServices.retrieveAccessToken(username, password, authenticationHeader);
        final String accessToken = new JSONDeserializer<Map<String, String>>().deserialize(oauthTokenResponse).get("access_token");

        final String authUserResponse = authServerServices.retrieveUserViaOAuthToken(accessToken);

        PreAuthenticatedAuthenticationToken preAuthenticatedAuthenticationToken = new PreAuthenticatedAuthenticationToken(HSUser.fromJson(authUserResponse), accessToken);
        preAuthenticatedAuthenticationToken.setAuthenticated(true);
        return preAuthenticatedAuthenticationToken;
/*      // TODO: Piyush get User object from DB perhaps.
        // UserDetails userDetails = new HSUser("piyush.ramavat", "Welcome@1", null);
        if (username.equals("piyush.ramavat") && password.equals("Welcome@1")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            auth = new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
        }
        return auth;
*/
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Required
    public void setAuthenticationHeader(String authenticationHeader) {
        this.authenticationHeader = authenticationHeader;
    }

}
