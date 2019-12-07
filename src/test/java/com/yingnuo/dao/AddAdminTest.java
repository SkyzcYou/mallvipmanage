package com.yingnuo.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.yingnuo.domain.Admin;
import com.yingnuo.service.AdminService;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/5
 * Time: 2:26
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AddAdminTest {
    public static DataSource dataSourceTest = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        dataSourceTest = cpds;
    }

    public static void main(String[] args) {
        AdminDao dao = new AdminDao();
        Admin newAdmin = new Admin();
        newAdmin.setAdmin_name("新管理员");
        newAdmin.setPassword("1234567");
        newAdmin.setNote("开发部高管");
        try {
            System.out.println(dao.addAdmin(newAdmin));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}