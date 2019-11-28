package com.yingnuo.dao;

import com.yingnuo.domain.User;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

    // 根据 phone 和 password 查找用户
    public User findUserByPhoneAndPassword(String phone,String password) throws SQLException {
        String sql = "select * from user where phone=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanHandler<User>(User.class),phone,password);
    }
}
