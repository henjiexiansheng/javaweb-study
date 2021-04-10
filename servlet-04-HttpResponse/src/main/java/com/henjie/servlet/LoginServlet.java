package com.henjie.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //后台接收时中文乱码问题
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbys = req.getParameterValues("hobbys");


        System.out.println("=========================");
        System.out.println(username);
        System.out.println(password);
        //Arrays.toString(数组名)  打印数组
        System.out.println(Arrays.toString(hobbys));
        System.out.println("=========================");

        //方法一：重定向到完成页面
        //resp.sendRedirect("/henjie/success.jsp");

        //方法二：请求转发方式到完成页面
        req.getRequestDispatcher("/success.jsp").forward(req,resp);

        resp.setCharacterEncoding("utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
