package com.yingnuo.web.servlet;

import com.yingnuo.domain.User;
import com.yingnuo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新用户资料等操作
 */
@WebServlet("/upgradeUser")
public class UpgradeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            System.out.println("session 中没有 user，没有登陆！");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        UserService userService = new UserService();
        User handleUser = new User();
        handleUser.setPhone(user.getPhone());
        handleUser.setUsername(req.getParameter("username"));
        handleUser.setGender(req.getParameter("gender"));
        handleUser.setAddress(req.getParameter("address"));

        try {
            userService.upgradeUserByPhone(handleUser);
            req.getSession().removeAttribute("user");
            req.getSession().setAttribute("user",userService.login(handleUser.getPhone(),user.getPassword()));
            resp.sendRedirect(req.getHeader("Referer"));//返回并刷新
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}