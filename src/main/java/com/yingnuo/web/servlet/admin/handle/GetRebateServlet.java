package com.yingnuo.web.servlet.admin.handle;

import com.google.gson.Gson;
import com.yingnuo.domain.User;
import com.yingnuo.domain.VipRule;
import com.yingnuo.service.UserService;
import com.yingnuo.service.VipRuleService;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据手机号和订单实际金额获取折扣和优惠后金额
 */
@WebServlet("/admin/getRebate")
public class GetRebateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String actual_amount =  req.getParameter("actual_amount");
        System.out.println("电话为："+phone+"-订单金额为："+actual_amount);

        UserService userService = new UserService();
        VipRuleService vipRuleService = new VipRuleService();
        int is_rank = 0;
        Double rebate = 0.0;
        int point = 0;
        double pay_amount = 0.0;
        // 根据手机号查找用户,并返回折扣
        try {
            User user = userService.findUserByPhone(phone);
            if (user!= null){
                point = Integer.parseInt(user.getPoint());
                List<VipRule> vipRuleList = vipRuleService.findAllVipRule();
                for (VipRule vipRule : vipRuleList){
                    if (point <= vipRule.getMax_point()){
                        is_rank = vipRule.getIs_rank();
                        rebate = vipRule.getRebate();
                        // 计算实付金额并返回
                        pay_amount = rebate * Integer.parseInt(actual_amount)/10;
                        break;
                    }else {
                        is_rank = 6;
                        rebate = vipRuleService.findRebateByRank(6);
                        pay_amount = rebate * Integer.parseInt(actual_amount)/10;
                    }
                }
            }else {
                System.out.println("获取User或折扣失败");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
        System.out.println("电话为："+phone+"-订单金额为："+actual_amount+"该用户积分为："+point+"该用户等级为:"+is_rank+"所享受折扣："+rebate+"实付金额为："+ pay_amount);
        // 利用 GSON 返回json对象
        PrintWriter out = resp.getWriter();
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg","true");
        map.put("point",String.valueOf(point));
        map.put("is_rank",String.valueOf(is_rank));
        map.put("rebate",String.valueOf(rebate));
        map.put("pay_amount",String.valueOf(pay_amount));

        Gson gson = new Gson();
        String json = gson.toJson(map);
        out.println(json);
        out.flush();
        out.close();
    }
}