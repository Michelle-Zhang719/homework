package com.fast.www.service;

import com.fast.www.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    AccountMapper accountMapper;


    //通过观察@Transactional注解，里面可以发现包含很多事务的定义相关的内容信息
    //实际上，你可以这么理解，我们可以在该注解中写一些设置，后续Spring会扫描该注解
    //会读取里面的配置信息，创建一个transactionTemplate
    //于此同时，我们也向Spring容器中注册了PlatformTransactionManager
    //Spring便会利用底层的AOP相关技术，帮助我们去执行对应的事务代码
    @Transactional
    @Override
    public void transfer(int fromId, int destId, double money) {
        accountMapper.updateMoneyByUid(fromId, money);

//        int i = 1 / 0;

        accountMapper.updateMoneyByUid(destId, -money);
    }
}
