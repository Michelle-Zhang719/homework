package org.fast.www.service;

/**
 * 目标类
 * @author minjie
 * @since 2023/05/11 21:08
 */

public class UserServiceImpl implements UserService{

    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String name() {
        return userMapper.queryName();
    }
}