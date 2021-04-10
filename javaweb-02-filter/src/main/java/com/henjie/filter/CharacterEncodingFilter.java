package com.henjie.filter;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始化，Web服务器启动就已经初始化了，随时等待过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    //chain 链
    /***
     *  1、过滤中的所有代码，在过滤特定请求的时候都会执行。
     *  2、必须要让过滤器继续通行
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("CharacterEncodingFilter 执行前……");
        filterChain.doFilter(servletRequest,servletResponse);   //让程序继续走，不写，程序到这里就被拦截停止了。
        System.out.println("CharacterEncodingFilter 执行后……");
    }

    //注销，Web服务器关闭时销毁
    public void destroy() {
        System.out.println("注销过滤器");
    }
}
