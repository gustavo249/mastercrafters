package com.mastercrafters.security;

import com.mastercrafters.model.User;
import com.mastercrafters.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 12/06/2016.
 */
@Service
public class DatabaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserRepository userRepository;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        boolean valid = true;

        final String password = (String) usernamePasswordAuthenticationToken.getCredentials();

        if (!StringUtils.hasText(password)) {
            this.logger.warn("Username {}: no password provided", userName);
            valid = false;
        }

        User user = userRepository.findOneByUsername(userName);
        System.err.println("DB pass: " + user.getPassword() + " ; AuthToken pass:" + password);
        if (user == null) {
            this.logger.warn("Username {}: user not found", userName);
            valid = false;
        } else {
            // Check password
            if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
                this.logger.warn("Username {}: bad password entered", userName);
                valid = false;
            }
        }

        if (!valid) {
            throw new BadCredentialsException("Invalid Username/Password for user " + userName);
        }
        final List<GrantedAuthority> auths = new ArrayList<>();
        // enabled, account not expired, credentials not expired, account not locked
        return new org.springframework.security.core.userdetails.User(userName, password, true, true, true, true, auths);
    }
}
