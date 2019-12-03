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
        handleUser.setUsername("Skyzc");
        handleUser.setPhone("15985428639");
        handleUser.setGender("男");
        handleUser.setAddress("贵州省瓮安县");
        UserService userService = new UserService();
        try {
            userService.upgradeUserByPhone(handleUser);
            System.out.println("更新用户资料成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}