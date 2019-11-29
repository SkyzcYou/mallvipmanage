package com.yingnuo.web.filter;

import com.yingnuo.domain.User;
import com.yingnuo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取 cookie
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        for (int i = 0;cookies != null && i<cookies.length;i++){
            if ("autologin".equals(cookies[i].getName())){
                autologin = cookies[i].getValue();
                break;
            }
        }
        // 自动登录
        if (autologin != null){
            String[] parts = autologin.split("-");
            String phone = parts[0];
            String password = parts[1];
            // 调用 Service 登录
            UserService userService = new UserService();
            try {
                User user = userService.login(phone,password);
                System.out.println("[AutoLoginFilter]-Auto Login Success：" + user.getUsername());
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }
        // 放行
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
