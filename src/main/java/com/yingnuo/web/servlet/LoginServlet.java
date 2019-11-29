package com.yingnuo.web.servlet;

import com.yingnuo.domain.User;
import com.yingnuo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("phone"));
//        System.out.println(req.getParameter("password"));

        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        try {
            User user = userService.login(phone,password);
            System.out.println("[LoginServlet]-Login Success：" + user.getUsername());
            // 发送 自动登录的 cookie
            String autoLogin = req.getParameter("autologin");
            if (autoLogin == null){
                Cookie cookie = new Cookie("autoLogin",phone+"-"+password);
                cookie.setMaxAge(60*60*24);  // Cookie 保留一天
                cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);
            }
            // 存入 session
            req.getSession().setAttribute("user",user);
            // 登录成功 跳转首页
            resp.sendRedirect(req.getContextPath()+"/index");
            return;
        } catch (LoginException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
