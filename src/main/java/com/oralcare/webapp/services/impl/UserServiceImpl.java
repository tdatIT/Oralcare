package com.oralcare.webapp.services.impl;

import com.oralcare.webapp.model.User;
import com.oralcare.webapp.repositories.UserRepo;
import com.oralcare.webapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean registerUser(User user) {
        if (findUserByUsername(user.getEmail()) == null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encrypt_password = encoder.encode(user.getPassword());
            user.setPassword(encrypt_password);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if (findUserByUsername(user.getEmail()) == null) {
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByEmail(username);
    }
}
