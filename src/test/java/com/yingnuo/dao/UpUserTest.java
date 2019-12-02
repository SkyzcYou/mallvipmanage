package com.yingnuo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yingnuo.domain.User;
import com.yingnuo.service.UserService;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UpUserTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(dataSourceTest.getConnection());

        User handleUser = new User();
        handleUser.setUsername("游正材");
        handleUser.setPhone("15985428639");
        handleUser.setGender("男");
        handleUser.setAddress("贵州省瓮安县");
        handleUser.setPoint("88");
        handleUser.setRank("1");
        UserService userService = new UserService();
        try {
            User newUser = userService.upgradeUserByPhone(handleUser);
            System.out.println(newUser.toString());
        } catch (Exception e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }

    }
}