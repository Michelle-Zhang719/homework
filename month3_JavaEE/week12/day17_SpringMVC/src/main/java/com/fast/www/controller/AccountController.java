package com.fast.www.controller;

import com.fast.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author minjie
 * @since 2023/05/16 19:48
 */

@Controller
public class AccountController {
    @Autowired
    UserService userService;
    //发送请求localhost:8080/transfer?fromId=1&destId=2&money=1000
    //在该Handler方法中完成由1给2转1000元的业务,要求包含事务
    @RequestMapping(value = "/transfer",produces ="text/html;charset=utf-8")
    @ResponseBody
    public Object transfer(Integer fromId, Integer destId, Double money) {
        userService.transfer(fromId, destId, money);
        return "转账成功";
    }
}