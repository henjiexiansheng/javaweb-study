package com.henjie.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /***
         * sendRedirect 的原理:
         * resp.setHeader("Location","/henjie/image");   位置设置成重定向的地址
         * resp.setStatus(302);     设置状态码为302，302代表重定向
         */
        //重定向
        resp.sendRedirect("/henjie/image");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
