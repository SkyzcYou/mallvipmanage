package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.yingnuo.domain.Admin;
import com.yingnuo.service.AdminService;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/5
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin/editAdmin")
public class UpdateAdminByAdminId extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否有 session
        if (req.getSession().getAttribute("admin") == null){
            System.out.println("session 中没有 admin，没有管理员登陆！请登录...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin_login.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        int admin_id = Integer.parseInt(req.getParameter("admin_id"));
        Admin admin = new Admin();
        admin.setAdmin_id(admin_id);
        admin.setAdmin_name(req.getParameter("admin_name"));
        admin.setPassword(req.getParameter("password"));
        admin.setNote(req.getParameter("note"));
        System.out.println(admin.toString());

        AdminService adminService = new AdminService();
        try {
            Boolean msg = adminService.updateAdminByAdminId(admin);

            // 利用 GSON 返回json对象
            PrintWriter out = resp.getWriter();
            Map<String,Boolean> map = new HashMap<String,Boolean>();
            map.put("msg",msg);
            Gson gson = new Gson();
            String json = gson.toJson(map);
            out.println(json);
            out.flush();
            out.close();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}