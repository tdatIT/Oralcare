package com.oralcare.webapp.services;

import com.oralcare.webapp.model.User;

public interface UserService {

    boolean registerUser(User user);

    boolean updateUser(User user);

    User findUserByUsername(String username);
}
