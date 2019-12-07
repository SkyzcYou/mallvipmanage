package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.yingnuo.domain.Ann;
import com.yingnuo.service.AnnService;

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
 * Date: 2019/12/6
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin/editAnn")
public class UpdateAnnByAnnId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否有 session
        if (req.getSession().getAttribute("admin") == null){
            System.out.println("session 中没有 admin，没有管理员登陆！请登录...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin_login.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        String ann_name = req.getParameter("ann_name");
        String ann_content = req.getParameter("ann_content01");
        if (req.getParameter("ann_id").equals("1")){
            ann_content = req.getParameter("ann_content01")+ "&"+req.getParameter("ann_content02")+ "&"+req.getParameter("ann_content03");
        }
        Ann ann = new Ann();
        ann.setAnn_name(ann_name);
        ann.setAnn_content(ann_content);
        System.out.println(ann.toString());

        AnnService annService = new AnnService();
        try {
            Boolean msg = annService.updateAnnByAnnName(ann);
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