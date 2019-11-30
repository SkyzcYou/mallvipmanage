package com.yingnuo.web.servlet.admin;

import com.yingnuo.domain.Admin;
import com.yingnuo.domain.User;
import com.yingnuo.service.AdminService;
import com.yingnuo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/11/30
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin_loginCheck")
public class AdminLoginCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("admin_name");
        String password = req.getParameter("password");
        System.out.println("管理员："+adminName+"-"+"密码："+ password);

        AdminService adminService = new AdminService();
        try {
            Admin admin = adminService.login(adminName,password);
            System.out.println("[AdminLoginServlet]-Login Success：" + admin.getAdmin_name());
            // 不用保存 cookie
//            String autoLoginAdmin = req.getParameter("autologin_admin");
//            if (autoLoginAdmin == null){
//                Cookie cookie = new Cookie("autoLogin_admin",adminName+"-"+password);
//                cookie.setMaxAge(60*60*24);  // Cookie 保留一天
//                cookie.setPath(req.getContextPath());
//                resp.addCookie(cookie);
//            }
            // 存入 session
            req.getSession().setAttribute("admin",admin);
            // 登录成功 跳转首页
            resp.sendRedirect(req.getContextPath()+"/index");
            return;
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}