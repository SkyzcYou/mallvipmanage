package com.yingnuo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yingnuo.domain.Order;
import com.yingnuo.domain.User;
import com.yingnuo.service.OrderService;
import com.yingnuo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/2
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class GetOrderByUserPhoneTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(dataSourceTest.getConnection());

        String phone = "15985428639";

        OrderService orderService = new OrderService();
        try {
            List<Order> orderArrayList = orderService.allOrderOfUser(phone);
            for (Order order : orderArrayList){
                System.out.println("订单号："+order.getOrder_id());
                System.out.println("订单金额："+order.getActual_amount());
                System.out.println("订单实付金额："+order.getPay_amount());
                System.out.println("订单创建时间："+order.getCreate_date());
                System.out.println(order.toString());
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
}