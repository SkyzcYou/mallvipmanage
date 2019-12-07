package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Order;
import com.yingnuo.domain.User;
import com.yingnuo.domain.VipRule;
import com.yingnuo.service.AdminService;
import com.yingnuo.service.OrderService;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/5
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@WebServlet("/admin/addOrder")
public class AddOrderServlet extends HttpServlet {
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
        Order order = new Order();
        order.setUser_phone(req.getParameter("user_phone"));
        order.setActual_amount(req.getParameter("actual_amount"));
        order.setPay_amount(req.getParameter("pay_amount"));



        Date now_date = new Date();
        order.setCreate_date(now_date);
        System.out.println(order.toString());

        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        try {
            Boolean msg = orderService.addOrder(order);
            if (msg){
                // 将用户的积分存入数据库
                User handUser = userService.findUserByPhone(req.getParameter("user_phone"));
                String old_point = handUser.getPoint();
                System.out.println("lod_point为：" +old_point);
                double pay_amount = Double.parseDouble(req.getParameter("pay_amount"));
                int new_point = Integer.parseInt(old_point)+ (int) pay_amount;
                handUser.setPoint(String.valueOf(new_point));

                // 获取会员体系 List 查询对应等级
                VipRuleService vipRuleService = new VipRuleService();
                List<VipRule> vipRuleList = null;
                try {
                    vipRuleList = vipRuleService.findAllVipRule();
                    for (VipRule vipRule : vipRuleList){
                        System.out.println("vipRule.getMax_point():"+vipRule.getMax_point());
                        if (new_point <= vipRule.getMax_point()){
                            handUser.setRank(String.valueOf(vipRule.getIs_rank()));
                            break;
                        }else {
                            handUser.setRank("6");
                        }
                    }
                } catch (LoginException e) {
                    e.printStackTrace();
                    System.out.println("[AddUserServlet]-获取会员体系失败");
                }

                Boolean isSavePoint = userService.upgradeUserPointByPhone(handUser);
                if (isSavePoint){
                    System.out.println("将用户的积分存入数据库成功");
                }else {
                    System.out.println("将用户的积分存入数据库失败");
                }
            }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}