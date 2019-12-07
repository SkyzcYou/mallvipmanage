package com.yingnuo.web.servlet.admin;

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
 * Date: 2019/12/5
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/adminLogout")
public class AdminLogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 用户注销
        req.getSession().removeAttribute("admin");
        resp.sendRedirect(req.getContextPath()+"/admin");
    }
}