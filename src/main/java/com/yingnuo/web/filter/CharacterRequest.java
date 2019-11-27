package com.yingnuo.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/*
*   继承默认包装类 HttpServletRequestWrapper
* */
public class CharacterRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public CharacterRequest(HttpServletRequest request){
        super(request);
        this.request = request;
    }
    // 重写 getParameter(String name)
    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        if (value == null){
            return null;
        }
        // 判断请求方式
        String method = super.getMethod();
        if ("get".equalsIgnoreCase(method)){
            try{
                value = new String(value.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }
        }
        // 返回已经解决乱码的结果
        return value;
    }
}
