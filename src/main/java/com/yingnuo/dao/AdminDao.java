package com.yingnuo.dao;

import com.yingnuo.domain.Admin;
import com.yingnuo.domain.User;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/11/30
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class AdminDao {

    // 根据管理员名字和密码查找管理员
    public Admin findAdminByAdminNameAndPassword(String admin_name,String password) throws SQLException{
        String sql = "select * from admin where admin_name=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanHandler<Admin>(Admin.class),admin_name,password);
    }
    // 获取所有管理员
    public List<Admin> findAllAdmin() throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from admin";
        return runner.query(sql,new BeanListHandler<Admin>(Admin.class));
    }
    // 根据admin_id删除管理员
    public Boolean deleteAdminByAdminId(String admin_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from admin where admin_id=?";
        int num = runner.update(sql,admin_id);
        return num >0;
    }
    // 根据admin_id修改管理员
    public Boolean updateAdminByAdminId(Admin admin) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update admin set admin_name=?,password=?,note=? where admin_id=?";
        int num = runner.update(sql,admin.getAdmin_name(),admin.getPassword(),admin.getNote(),admin.getAdmin_id());
        return num>0;
    }
    // 添加一个管理员
    public Boolean addAdmin(Admin admin) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into admin (admin_name,password,note) values (?,?,?)";
        int num = runner.update(sql, admin.getAdmin_name(),admin.getPassword(),admin.getNote());
        return num>0;
    }

}