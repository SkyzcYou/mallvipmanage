package com.yingnuo.dao;

import javax.security.auth.login.LoginException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yingnuo.domain.User;
import com.yingnuo.service.UserService;

import java.sql.SQLException;


public class DataSourceTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) throws SQLException {
       UserDao userDao = new UserDao();
       OrderDao orderDao = new OrderDao();

        System.out.println("订单量："+orderDao.countOrder());
       System.out.println("用户量："+userDao.countUser());
        System.out.println("订单成交额："+orderDao.allPlayAmount());
        System.out.println("订单成交额："+userDao.allPoint());


    }
}
