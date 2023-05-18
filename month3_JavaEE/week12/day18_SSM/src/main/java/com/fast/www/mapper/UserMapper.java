package com.fast.www.mapper;

import com.fast.www.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int addUser(@Param("user") User user);

    User selectUser(@Param("username")String username , @Param("password") String password);
}
