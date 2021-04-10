package com.henjie.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到Session
        HttpSession session = req.getSession();
        //给Session中存入东西
        session.setAttribute("name","恨劫");
        //获取session的id
        String id = session.getId();
        //判断是不是新创建的session
        if(session.isNew()){
            resp.getWriter().write("Session创建成功，id为："+id);
        }
        else{
            resp.getWriter().write("Session已经存在于服务器，id为："+id);
        }

        //Session创建时做了什么事情
//        Cookie cookie = new Cookie("JSESSIONID", id);
//        resp.addCookie(cookie);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
