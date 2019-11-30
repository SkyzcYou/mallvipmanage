package com.yingnuo.web.filter;

import com.yingnuo.domain.User;
import com.yingnuo.service.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
*   用户自动登录
* */
public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 获取 session 中是否有 user ，如果有就表示已经登录
        if (request.getSession().getAttribute("user") == null){
            // 获取 cookie
            Cookie[] cookies = request.getCookies();
            // System.out.println("cookies[0] name:"+ cookies[0].getName()+",cookies[0] value:" + cookies[0].getValue());
            String autoLogin = null;
            // 找到 cookie : autoLogin
            for (int i = 0;i<cookies.length;i++){
                if ("autoLogin".equals(cookies[i].getName())){
                    autoLogin = cookies[i].getValue();
                    break;
                }
            }
            // 自动登录
            if (autoLogin != null){
                String[] parts = autoLogin.split("-");
                String phone = parts[0];
                String password = parts[1];
                // 调用 Service 登录
                UserService userService = new UserService();
                try {
                    User user = userService.login(phone,password);
                    request.getSession().setAttribute("user",user);
                    System.out.println("[AutoLoginFilter]-Auto Login Success：" + user.getUsername());
                } catch (LoginException e) {
                    e.printStackTrace();
                }
            }
        }

        // 放行
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
