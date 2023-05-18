package com.fast.www.controller;

import com.fast.www.domain.User;
import com.fast.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 用户相关操作
 *
 * @author minjie
 * @since 2023/05/17 16:56
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    @ResponseBody
    public String register(String username, String password, MultipartFile image) throws IOException {
        // 生成随机的文件名
        String originalFileName = image.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); //获取后缀
        String randomFileName = UUID.randomUUID().toString() + extension;

        // 获取应用根目录的路径
        String rootPath = "D:\\test\\img";
        String savePath = rootPath + "/" + randomFileName;

        // 存储文件到应用根目录
        try {
            image.transferTo(new File(savePath));
            // 文件存储成功
        } catch (IOException e) {
            // 文件存储失败，处理异常
            throw new RuntimeException(e);
        }

        // 返回结果或进行其他操作
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setImageurl(savePath);

        userService.register(user);

        return "注册成功";
    }

    @PostMapping("login")
    public void login(String username, String password, HttpServletResponse response, HttpServletRequest request) throws IOException {
        User user = userService.login(username, password);
        request.getSession().setAttribute("user", user);
        response.setHeader("refresh", "2; url = /info.jsp");
    }

    @GetMapping("info")
    @ResponseBody
    public String info(HttpServletRequest request, Model model) {
        Object user = request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "user";
    }
}

