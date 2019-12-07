package com.yingnuo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yingnuo.domain.Admin;
import com.yingnuo.service.AdminService;

import javax.security.auth.login.LoginException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/4
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class GetAllAdminTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        try {
            System.out.println(dataSourceTest.getConnection());
            List<Admin> adminList = adminService.findAllAdmin();
            for (Admin admin : adminList){
                System.out.println(admin.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
}