package com.oralcare.webapp.services.impl;

import com.oralcare.webapp.model.CustomUserDetails;
import com.oralcare.webapp.model.User;
import com.oralcare.webapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user != null) {
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("Not found account have email");
    }
}
