package com.ems.service;

import com.ems.dao.UserDao;
import com.ems.model.User;

public class AuthService {

    private final UserDao userDao = new UserDao();

    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
