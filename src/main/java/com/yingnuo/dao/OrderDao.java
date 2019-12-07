package com.yingnuo.dao;


import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Order;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    // 获取订单量
    public long countOrder() throws SQLException {
        String sql= "select count(*) from all_order";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        long num = (long) runner.query(sql,new ScalarHandler());
        return num;
    }
    // 获取订单成交额 pay_amount
    public Double allPlayAmount() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql= "select sum(pay_amount) from all_order";
        Double num = (Double) runner.query(sql,new ScalarHandler());
        return num;
    }
    // 根据用户手机号查询订单
    public List<Order> findOrderByUserPhone(String user_phone) throws SQLException {
        String sql = "select * from all_order where user_phone=? order by create_date desc";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Order>(Order.class),user_phone);
    }
    // 获取所有订单
    public List<Order> findAllOrder() throws SQLException{
        String sql = "select * from all_order order by create_date desc";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Order>(Order.class));
    }
    // 根据order_id删除订单
    public Boolean deleteOrderByOrderId(String order_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from all_order where order_id=?";
        int num = runner.update(sql,order_id);
        return num >0;
    }
    // 根据order_id修改订单信息
    public Boolean updateOrderByOrderId(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update all_order set user_phone=?,actual_amount=?,pay_amount=? where order_id=?";
        int num = runner.update(sql,order.getUser_phone(),order.getActual_amount(),order.getPay_amount(),order.getOrder_id());
        return num>0;
    }
    // 添加一个订单
    public Boolean addOrder(Order order) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into all_order (user_phone,actual_amount,pay_amount,create_date) values (?,?,?,?)";
        int num = runner.update(sql, order.getUser_phone(),order.getActual_amount(),order.getPay_amount(),order.getCreate_date());
        return num>0;
    }
    // 获取最新 5 条订单
    public List<Order> findNewFiveOrder() throws SQLException{
        String sql = "select * from all_order order by create_date desc limit 0,5";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Order>(Order.class));
    }
}