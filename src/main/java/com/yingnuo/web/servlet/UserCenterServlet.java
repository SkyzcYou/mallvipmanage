package com.yingnuo.web.servlet;

import com.yingnuo.domain.Order;
import com.yingnuo.domain.User;
import com.yingnuo.domain.VipRule;
import com.yingnuo.service.VipRuleService;
import com.yingnuo.service.OrderService;
import com.yingnuo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userCenter")
public class UserCenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            // 用户
            System.out.println("session 中没有 user，没有登陆！");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req,resp);
            return;
        }
        // 重新登录刷新 session
        UserService userService = new UserService();
        String phone = user.getPhone();
        String password = user.getPassword();
        try {
            req.getSession().removeAttribute("user");
            user = userService.login(phone,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 获取当前用户积分，根据会员体系返回等级和折扣
        VipRuleService vipRuleService = new VipRuleService();
        List<VipRule> vipRuleList = null;
        Double userReabate = null;
        int user_point = Integer.parseInt(user.getPoint());
        try {
            vipRuleList = vipRuleService.findAllVipRule();
            for (VipRule vipRule : vipRuleList){
                if (user_point <= vipRule.getMax_point()){
                    user.setRank(String.valueOf(vipRule.getIs_rank()));
                    userReabate = vipRule.getRebate();
                    break;
                }else {
                    user.setRank("6");
                    userReabate = vipRuleService.findRebateByRank(6);
                }
            }
        } catch (LoginException e) {
            e.printStackTrace();
            System.out.println("[UserCenterServlet]-获取会员体系失败");
        }

        req.getSession().setAttribute("user",user);
        req.setAttribute("UserRebate",userReabate);


        // 获取 用户的全部订单
        OrderService orderService = new OrderService();
        try {
            List<Order> orderList = orderService.allOrderOfUser(user.getPhone());
            req.setAttribute("orderList",orderList);
            System.out.println("[UserCenterServlet]-获取用户："+ user.getUsername()+ " 的订单列表成功");
        } catch (LoginException e) {
            e.printStackTrace();
            req.setAttribute("orderList","error");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/client/userCenter.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
