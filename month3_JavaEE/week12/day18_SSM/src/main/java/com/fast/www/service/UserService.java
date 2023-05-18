package com.fast.www.service;

import com.fast.www.domain.User;

public interface UserService {
    int register(User user);

    User login(String username, String password);
}
