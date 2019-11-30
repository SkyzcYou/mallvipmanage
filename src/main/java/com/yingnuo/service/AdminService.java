package com.yingnuo.service;

import com.yingnuo.dao.AdminDao;
import com.yingnuo.domain.Admin;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class AdminService {
    AdminDao dao = new AdminDao();
    // 管理员登录
    public Admin login(String admin_name,String password) throws LoginException {
        try {
            Admin admin = dao.findAdminByAdminNameAndPassword(admin_name,password);
            if (admin != null){
                return admin;
            }
            throw new LoginException("管理员名称或密码有误");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("登录失败");
        }
    }
}