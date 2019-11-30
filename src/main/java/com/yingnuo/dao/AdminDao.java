package com.yingnuo.dao;

import com.yingnuo.domain.Admin;
import com.yingnuo.domain.User;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

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
}