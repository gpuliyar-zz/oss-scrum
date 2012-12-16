package oss.process.scrum.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service(value = "authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
    private AuthenticationManager authenticationManager;

    @Override
    public boolean login(String userName, String userPassword) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        if (authenticate.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return true;
        }

        return false;
    }
}
