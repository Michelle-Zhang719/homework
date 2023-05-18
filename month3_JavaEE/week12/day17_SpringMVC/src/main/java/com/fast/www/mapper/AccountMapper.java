package com.fast.www.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    void updateMoneyByUid(@Param("uid") int uid, @Param("money") double money);
}
