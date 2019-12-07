package com.yingnuo.service;


import com.yingnuo.dao.OrderDao;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Order;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    // 获取所有订单
    public List<Order> findAllOrder () throws LoginException{
        try {
            List<Order> orderList = dao.findAllOrder();
            if (orderList != null){
                return orderList;
            }
            throw new LoginException("获取订单列表出错");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取订单列表失败");
        }
    }
    // 根据order_id删除订单
    public Boolean deleteOrderByOrderId(String order_id) throws LoginException {
        try {
            return dao.deleteOrderByOrderId(order_id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("删除订单失败");
        }
    }
    // 根据order_id修改订单信息
    public Boolean updateOrderByOrderId(Order order) throws LoginException {
        try {
            return dao.updateOrderByOrderId(order);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("修改订单失败");
        }
    }
    // 添加一个订单
    public Boolean addOrder(Order order) throws LoginException {
        try {
            return dao.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("添加订单失败");
        }
    }
    // 获取最新 5 条订单
    public List<Order> findNewFiveOrder () throws LoginException{
        try {
            return dao.findNewFiveOrder();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取最新5条订单失败");
        }
    }
    // 获取订单量
    public long countOrder() throws LoginException {
        try {
            return dao.countOrder();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取订单量失败");
        }
    }
    // 获取订单成交额 pay_amount
    public Double allPlayAmount() throws LoginException {
        try {
            return dao.allPlayAmount();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取订单成交额失败");
        }
    }
}