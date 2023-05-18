package org.fast.www.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用动态代理
 *
 * @author minjie
 * @since 2023/05/11 20:16
 */
@WebServlet("/hello")
public class HelloController extends HttpServlet {

    UserService userService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = userService.name();
        System.out.println(name);
    }
}



