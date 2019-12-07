package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.User;
import com.yingnuo.service.AdminService;
import com.yingnuo.service.UserService;

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
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/5
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin/delAdminByAdminId")
public class DelAdminByAdminIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
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
        String admin_id = req.getParameter("admin_id");
        System.out.println(admin_id);
        AdminService adminService = new AdminService();
        try {
            Boolean msg = adminService.deleteAdminByAdminId(admin_id);
//            req.setAttribute("msg",msg);

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