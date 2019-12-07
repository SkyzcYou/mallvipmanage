package com.yingnuo.service;

import com.yingnuo.dao.AdminDao;
import com.yingnuo.domain.Admin;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.List;

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
    // 获取所有管理员
    public List<Admin> findAllAdmin () throws LoginException{
        try {
            List<Admin> adminList = dao.findAllAdmin();
            if (adminList != null){
                return adminList;
            }
            throw new LoginException("获取管理员列表出错");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取管理员列表失败");
        }
    }
    // 根据 admin_id 删除管理员
    public Boolean deleteAdminByAdminId(String admin_id) throws LoginException{
        try {
            return dao.deleteAdminByAdminId(admin_id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("删除失败");
        }
    }
    // 根据admin_id修改管理员
    public Boolean updateAdminByAdminId(Admin admin) throws LoginException {
        try {
            return dao.updateAdminByAdminId(admin);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("更新失败");
        }
    }
    // 添加一个管理员
    public Boolean addAdmin(Admin admin) throws LoginException {
        try {
            return dao.addAdmin(admin);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("添加失败");
        }
    }

}