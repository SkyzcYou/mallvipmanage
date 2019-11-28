package com.yingnuo.service;

import com.yingnuo.dao.UserDao;
import com.yingnuo.domain.User;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class UserService {
    UserDao dao = new UserDao();
    // 登录
    public User login(String phone,String password) throws LoginException{
        try {
            User user = dao.findUserByPhoneAndPassword(phone,password);
            throw new LoginException("手机号或密码有误");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("登录失败");
        }
    }
}
