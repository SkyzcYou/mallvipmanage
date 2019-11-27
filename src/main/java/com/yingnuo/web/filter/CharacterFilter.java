package com.yingnuo.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*   利用 CharacterFilter 实现全站统一编码
* */
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        System.out.println("Request URL：" + url);
        // 过滤静态文件
        if (url.indexOf(".css")>0 || url.indexOf(".js")>0 || url.indexOf(".png")>0 || url.indexOf(".jpg")>0){

        }else {
            response.setContentType("text/html;charset=utf-8");
        }

        // 拦截所有请求 解决中文乱码。指定 request 和 response 的编码格式
        request.setCharacterEncoding("utf-8");  // 只对消息体有效

        // 对request 进行包装
        CharacterRequest characterRequest = new CharacterRequest(request);
        filterChain.doFilter(characterRequest,response);
    }

    @Override
    public void destroy() {

    }
}

