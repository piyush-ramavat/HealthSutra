package au.com.healthsutra.service;

import au.com.healthsutra.dao.HSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

@Service
public class HSAuthenticationService {

    private static final Logger LOG = LoggerFactory.getLogger(HSAuthenticationService.class);

    public OAuth2Authentication getAuthentication() {
        final SecurityContext context = SecurityContextHolder.getContext();
        return (OAuth2Authentication) context.getAuthentication();
    }

    public HSUser getUserDetail() {
        return (HSUser) getAuthentication().getPrincipal();
    }
/*
    private User getUser() {
        return (User) getAuthentication().getPrincipal();
    }


    public AuthenticatedUserData getUserDetail() throws DomainServiceException, IOException {
        final User user = getUser();
        String username = user.getUsername();
        StaffgetRequest request = StaffgetRequest.initWithUsername(username).withShowPolicy(true);
        StaffgetCommand command = new StaffgetCommand(request);
        TransactionResponse response = command.execute();
        if (response.isOK()) {
            return new AuthenticatedUserData(user, response);
        }

        throw new DomainServiceException("Staffget is not returning expected response for username : " + username)
                .withErrorCode(String.valueOf(response.errorCode()))
                .withErrorSystemMessage(response.errorMessage());
    }
*/
}
