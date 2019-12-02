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
    // 根据手机号更新用户信息
    public Boolean upgradeUserByPhone(User user) throws SQLException{
        String sql = "update user set username=?,gender=?,address=? where phone=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int num = runner.update(sql,new Object[]{user.getUsername(),user.getGender(),user.getAddress(),user.getPhone()});
        return num > 0;
    }
}
