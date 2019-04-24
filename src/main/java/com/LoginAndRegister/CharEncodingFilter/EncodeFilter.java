package com.LoginAndRegister.CharEncodingFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenzhengfu
 */
//@WebFilter(urlPatterns = "/*",filterName = "myEncodeFilter")
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("编码过滤器初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("编码过滤器销毁");
    }
}
