package com.yingnuo.dao;

import com.google.gson.internal.$Gson$Preconditions;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.Order;
import com.yingnuo.domain.User;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    // 获取用户量
    public long countUser() throws SQLException{
        String sql= "select count(*) from user";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        long num = (long) runner.query(sql,new ScalarHandler());
        return num;
    }
    // 获取所有积分
    public Double allPoint() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql= "select sum(point) from user";
        Double num = (Double) runner.query(sql,new ScalarHandler());
        return num;
    }
    // 获取所有用户
    public List<User> findAllUser() throws SQLException{
        String sql = "select * from user";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<User>(User.class));
    }
    // 根据 phone 和 password 查找用户
    public User findUserByPhoneAndPassword(String phone,String password) throws SQLException {
        String sql = "select * from user where phone=? and password=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanHandler<User>(User.class),phone,password);
    }
    // 根据手机号修改用户信息 (username,gender,address)
    public Boolean upgradeUserByPhone(User user) throws SQLException{
        String sql = "update user set username=?,gender=?,address=? where phone=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int num = runner.update(sql, user.getUsername(),user.getGender(),user.getAddress(),user.getPhone());
        return num > 0;
    }
    // 根据手机号修改用户信息 (username,gender,address)
    public Boolean upgradeUserPointByPhone(User user) throws SQLException{
        String sql = "update user set point=?,rank=? where phone=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        int num = runner.update(sql, user.getPoint(),user.getRank(),user.getPhone());
        return num > 0;
    }

    // 根据user_id删除用户
    public Boolean deleteUserByUserId(String user_id) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from user where user_id=?";
        int num = runner.update(sql,user_id);
        return num >0;
    }
    // 根据user_id修改用户
    public Boolean updateUserByUserId(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set username=?,phone=?,password=?,gender=?,address=?,point=?,rank=? where user_id=?";
        int num = runner.update(sql, user.getUsername(),user.getPhone(),user.getPassword(),user.getGender(),user.getAddress(),user.getPoint(),user.getRank(),user.getUser_id());
        return num > 0;
    }
    // 添加一个用户
    public Boolean addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user (username,phone,password,gender,address,point,rank) values (?,?,?,?,?,?,?)";
        int num = runner.update(sql, user.getUsername(),user.getPhone(),user.getPassword(),user.getGender(),user.getAddress(),user.getPoint(),user.getRank());
        return num>0;
    }
    // 根据手机号查找用户
    public User findUserByPhone(String phone) throws SQLException {
        String sql = "select * from user where phone=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql,new BeanHandler<User>(User.class),phone);
    }

}
