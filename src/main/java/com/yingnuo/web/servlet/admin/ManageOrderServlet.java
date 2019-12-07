package com.yingnuo.web.servlet.admin;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Order;
import com.yingnuo.service.AdminService;
import com.yingnuo.service.OrderService;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/4
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin/manageOrder")
public class ManageOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否有 session
        if (req.getSession().getAttribute("admin") == null){
            //
            System.out.println("session 中没有 admin，没有管理员登陆！请登录...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin_login.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        // 如果有 session ，表示有管理已经登录了，连接到公告管理
        OrderService orderService = new OrderService();
        try {
            List<Order> orderList = orderService.findAllOrder();
            req.setAttribute("orderList",orderList);
        } catch (LoginException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin_order_management.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}