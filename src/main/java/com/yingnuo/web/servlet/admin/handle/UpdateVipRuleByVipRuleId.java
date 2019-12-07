package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.yingnuo.domain.VipRule;
import com.yingnuo.service.VipRuleService;

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
*   修改会员体系规则
* */
@WebServlet("/admin/editVipRule")
public class UpdateVipRuleByVipRuleId extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否有 session
        if (req.getSession().getAttribute("admin") == null){
            System.out.println("session 中没有 admin，没有管理员登陆！请登录...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/admin_login.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        VipRule vipRule = new VipRule();
        vipRule.setId(Integer.parseInt(req.getParameter("id")));
        vipRule.setMax_point(Integer.parseInt(req.getParameter("max_point")));
        vipRule.setIs_rank(Integer.parseInt(req.getParameter("is_rank")));
        vipRule.setRebate(Double.valueOf(req.getParameter("rebate")));
        System.out.println("[UpdateVipRuleByVipRuleId]-HandleVipRule为："+vipRule.toString());

        VipRuleService vipRuleService = new VipRuleService();
        try {
            Boolean msg = vipRuleService.updateVipRuleById(vipRule);
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