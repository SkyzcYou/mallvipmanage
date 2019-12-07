package com.yingnuo.service;

import com.yingnuo.dao.UserDao;
import com.yingnuo.domain.Admin;
import com.yingnuo.domain.User;
import com.yingnuo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao dao = new UserDao();

    // 登录
    public User login(String phone, String password) throws LoginException {
        try {
            User user = dao.findUserByPhoneAndPassword(phone, password);
            if (user != null) {
                return user;
            }
            throw new LoginException("手机号或密码有误");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("登录失败");
        }
    }

    // 更新
    public Boolean upgradeUserByPhone(User user) throws Exception {
        try {
            return dao.upgradeUserByPhone(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("更新失败");
        }
    }

    // 获取所有用户
    public List<User> findAllUser() throws LoginException {
        try {
            List<User> userList = dao.findAllUser();
            if (userList != null) {
                return userList;
            }
            throw new LoginException("获取所有用户出错");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取所有用户失败");
        }
    }

    // 根据user_id删除用户
    public Boolean deleteUserByUserId(String user_id) throws LoginException {
        try {
            return dao.deleteUserByUserId(user_id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("删除用户失败");
        }
    }

    // 根据user_id修改用户
    public Boolean updateUserByUserId(User user) throws LoginException {
        try {
            return dao.updateUserByUserId(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("修改用户失败");
        }
    }
    // 根据手机号修改用户信息 (username,gender,address)
    public Boolean upgradeUserPointByPhone(User user) throws LoginException{
        try {
            return dao.upgradeUserPointByPhone(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("修改积分失败");
        }
    }

    // 添加一个用户
    public Boolean addUser(User user) throws LoginException {
        try {
            return dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("添加用户失败");
        }
    }

    // 获取用户量
    public long countUser() throws LoginException {
        try {
            return dao.countUser();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取用户量失败");
        }
    }

    // 获取所有积分
    public Double allPoint() throws LoginException {
        try {
            return dao.allPoint();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("获取所有积分失败");
        }
    }
    // 根据手机号查找用户
    public User findUserByPhone(String phone) throws LoginException {
        try {
            return dao.findUserByPhone(phone);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("查找失败");
        }
    }
}
