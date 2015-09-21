package au.com.healthsutra.controllers;

import au.com.healthsutra.dao.HSUser;
import au.com.healthsutra.service.HSAuthenticationService;
import au.com.healthsutra.service.HSServiceException;
import au.com.healthsutra.service.RestfulSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Collection;

@Controller
@RequestMapping("/auth")
public class AuthenticationController extends RestfulSupport {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private HSAuthenticationService authentication;

    @RequestMapping(value = "/validate")
    public ResponseEntity<String> validateToken() throws IOException {
        return responseWith(HttpStatus.OK);
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public
    @ResponseBody
    OAuth2Authentication getAuthentication() {
        return authentication.getAuthentication();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public
    @ResponseBody
    HSUser getDetail() throws HSServiceException, IOException {
        return authentication.getUserDetail();
    }

    @RequestMapping(value = "/user/authorities", method = RequestMethod.POST)
    public
    @ResponseBody
    Collection<GrantedAuthority> getAuthorities() throws HSServiceException, IOException {
        HSUser userDetail = authentication.getUserDetail();
        return userDetail.getAuthorities();
    }

    @RequestMapping(value = "/user/authorities/{authority}", method = RequestMethod.POST)
    public
    @ResponseBody
    Boolean checkAuthority(@PathVariable final String authority) throws HSServiceException, IOException {
        HSUser userDetail = authentication.getUserDetail();
        Collection<GrantedAuthority> authorities = userDetail.getAuthorities();
        GrantedAuthority searchFor = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return authority;
            }
        };
        return authorities.contains(searchFor);
    }
/*
    These are not required for now.
    When needed, Add a field named groups in HSUser class, set them in constructor, define getter() and uncomment this request if needed.
    @RequestMapping(value = "/user/groups/{group}", method = RequestMethod.POST)
    public @ResponseBody
    Boolean checkGroup(@PathVariable final String group) throws HSServiceException, IOException {
        HSUser userDetail = authentication.getUserDetail();
        Collection<String> groups = userDetail.getGroups();
        return groups.contains(group);
    }

    @RequestMapping(value = "/user/groups", method = RequestMethod.POST)
    public @ResponseBody
    Collection<String> getGroups() throws HSServiceException, IOException {
        HSUser userDetail = authentication.getUserDetail();
        return userDetail.getGroups();
    }

*/

}
