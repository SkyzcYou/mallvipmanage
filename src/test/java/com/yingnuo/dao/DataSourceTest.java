package com.yingnuo.dao;

import javax.security.auth.login.LoginException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
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
        System.out.println(dataSourceTest.getConnection());

        String phone = "15985428639";
        String password = "140472";

        UserService userService = new UserService();
        try {
            User user = userService.login(phone,password);
            System.out.println("用户名为：" + user.getUsername());
            System.out.println("用户手机号为：" + user.getPhone());
            System.out.println("用户密码为：" + user.getPassword());
            System.out.println("用户性别为：" + user.getGender());
            System.out.println("用户住址为：" + user.getAddress());
            System.out.println("用户积分为：" + user.getPoint());
            System.out.println("用户等级为：" + user.getRank());
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
}
