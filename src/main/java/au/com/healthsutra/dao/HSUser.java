package au.com.healthsutra.dao;

import flexjson.JSONDeserializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HSUser extends User {

    public HSUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public HSUser(User user) {
        super(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    public static HSUser fromJson(final String jsonResponse) {
        Map<String, Object> response = new JSONDeserializer<Map<String, Object>>().deserialize(jsonResponse);
        Map<String, Object> userData = (Map<String, Object>) response.get("userData");
        String username = String.valueOf(userData.get("username"));

        List<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
        List<Map<String, String>> authoritiesInJson = (List<Map<String, String>>) userData.get("authorities");
        for (final Map<String, String> each : authoritiesInJson) {
            authorities.add(new GrantedAuthority() {
                public String getAuthority() {
                    return each.get("authority");
                }
            });
        }

        // TODO: Piyush: check whether password has to be null
        return new HSUser(username, null, authorities);
/*
        HSUser staffUserData = new HSUser(username, null, authorities);

        String passwordExpiredInString = String.valueOf(response.get("passwordExpired"));
        if(passwordExpiredInString != null && !passwordExpiredInString.isEmpty()){
            staffUserData.withPasswordExpiredOn(new Date(Long.valueOf(passwordExpiredInString)));
        }
        staffUserData.withFullname(String.valueOf(response.get("fullname")));

        staffUserData.withEmployeeId(String.valueOf(response.get("employeeId")));

        staffUserData.withEmail(String.valueOf(response.get("email")));

        staffUserData.withUamGroups((List<String>) userData.get("uamGroups"));

        return staffUserData;
*/

    }
}
