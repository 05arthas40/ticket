package com.LoginAndRegister.XssFilter;

import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebFilter(urlPatterns = "/*",filterName = "XSSFilter")
public class XssHttpFilter implements Filter {

        @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        System.out.println("过滤js脚本");
        //使用装饰者模式
        XssHttpServletRequestWrapper requestWrapper=new XssHttpServletRequestWrapper(request);
        filterChain.doFilter(requestWrapper,response);
    }
    @Override
    public void destroy() {
        System.out.println("filter销毁");
    }
}
