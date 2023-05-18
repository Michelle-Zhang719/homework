package com.fast.www.service.Impl;

import com.fast.www.domain.User;
import com.fast.www.mapper.UserMapper;
import com.fast.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author minjie
 * @since 2023/05/17 20:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int register(User user) {

        int resultCode = userMapper.addUser(user);
        return resultCode;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectUser(username, password);
        return user;
    }
}

