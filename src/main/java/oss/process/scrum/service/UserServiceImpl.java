package oss.process.scrum.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {
    private Map<String, User> users = new HashMap<String, User>();

    @PostConstruct
    public void init() {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<GrantedAuthority> adminAuthorities = new ArrayList<GrantedAuthority>();
        adminAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        List<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();
        userAuthorities.add(new SimpleGrantedAuthority("ROLE_REGISTERED"));

        users.put("admin", new User("admin", "admin", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, adminAuthorities));
        users.put("users", new User("users", "users", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, userAuthorities));
    }

    @Override
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
        User user = users.get(username);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("UserAccount for name \"" + username + "\" not found.");
        }
    }
}
