package au.com.healthsutra.service;

import au.com.healthsutra.dao.HSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

public class HSTokenServices extends DefaultTokenServices {

    private static final Logger LOG = LoggerFactory.getLogger(HSTokenServices.class);

    @Override
    public OAuth2Authentication loadAuthentication(final String accessTokenValue) throws AuthenticationException {
        final OAuth2Authentication oAuth2Authentication = super.loadAuthentication(accessTokenValue);

        final Object principal = oAuth2Authentication.getUserAuthentication().getPrincipal();

        if (principal instanceof HSUser) {
            final HSUser currentUserDetails = (HSUser) principal;
            String userName = currentUserDetails.getUsername();
            if (isUserNotActive(userName)) {
                LOG.debug("Username : " + userName + " is NOT Active. Revoking access token.");
                super.revokeToken(accessTokenValue);
                throw new InvalidTokenException("Access token expired: " + accessTokenValue);
            }
        } else {
            super.revokeToken(accessTokenValue);
            throw new InvalidTokenException("Access token invalid: " + accessTokenValue);
        }

        return oAuth2Authentication;
    }

    private boolean isUserNotActive(String userName) {
        //TODO: Piyush: get User from DB using UserName and validate if Active
        return "piyush.ramavat".equals(userName);
    }
}
