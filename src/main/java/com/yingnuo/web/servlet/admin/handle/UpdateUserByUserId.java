package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.User;
import com.yingnuo.domain.VipRule;
import com.yingnuo.service.AdminService;
import com.yingnuo.service.UserService;
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
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/5
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin/editUser")
public class UpdateUserByUserId extends HttpServlet {
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
        int user_id = Integer.parseInt(req.getParameter("user_id"));
        User user = new User();
        user.setUser_id(user_id);
        user.setUsername(req.getParameter("username"));
        user.setPhone(req.getParameter("phone"));
        user.setPassword(req.getParameter("password"));
        user.setGender(req.getParameter("gender"));
        user.setAddress(req.getParameter("address"));
        user.setPoint(req.getParameter("point"));
//        user.setRank(req.getParameter("rank"));
        // 获取会员体系 List 查询对应等级
        VipRuleService vipRuleService = new VipRuleService();
        List<VipRule> vipRuleList = null;
        int user_point = Integer.parseInt(req.getParameter("point"));
        System.out.println("user_point:"+user_point);
        try {
            vipRuleList = vipRuleService.findAllVipRule();
            for (VipRule vipRule : vipRuleList){
                System.out.println("vipRule.getMax_point():"+vipRule.getMax_point());
                if (user_point <= vipRule.getMax_point()){
                    user.setRank(String.valueOf(vipRule.getIs_rank()));
                    break;
                }else {
                    user.setRank("6");
                }
            }
        } catch (LoginException e) {
            e.printStackTrace();
            user.setRank("出错啦");
        }
        System.out.println(user.toString());

        UserService userService = new UserService();
        try {
            Boolean msg = userService.updateUserByUserId(user);

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