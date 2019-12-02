package com.yingnuo.service;


import com.yingnuo.dao.OrderDao;
import com.yingnuo.domain.Order;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderDao dao = new OrderDao();

    // 获取某个用户的所有订单
    public List<Order> allOrderOfUser(String phone)throws LoginException{

        try {
            ArrayList<Order> orderArrayList = (ArrayList<Order>) dao.findOrderByUserPhone(phone);
            if (orderArrayList != null){
                return  orderArrayList;
            }
            throw new LoginException("获取订单出错");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取订单失败");
        }

    }
}