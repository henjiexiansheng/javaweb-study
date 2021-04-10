package com.henjie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取资源流，读取db.properties，路径为编译生成的路径
        InputStream stream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        //常用类
        Properties prop = new Properties();
        //将获取的流加载进去,就读取了文件
        prop.load(stream);
        //获取文件中的属性
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        resp.getWriter().print(username+password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
