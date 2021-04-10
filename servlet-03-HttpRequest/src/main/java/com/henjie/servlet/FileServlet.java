package com.henjie.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 要获取下载文件的路径
//        String realPath = this.getServletContext().getRealPath("/image.png");
        String realPath = "D:\\桌面\\java\\javaweb\\servlet-03-HttpRequest\\src\\main\\resources\\image.png";
        System.out.println("下载文件的路径"+realPath);
//        2. 下载的文件名是什么
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
//        3. 让浏览器支持(Content-Disposition)要下载的东西
        resp.addHeader("Content-Disposition","attachment;filename="+fileName);
//        4. 获取下载文件的输入流（将文件变成流）
        FileInputStream in = new FileInputStream(realPath);
//        5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
//        6. 获取Outputstream对象
        ServletOutputStream out = resp.getOutputStream();
//        7. 将FileOutputstream写入到缓冲区（buffer）,使用Outputstream将缓冲区的数据输出到客户端
        while ((len = in.read(buffer)) > 0){
            out.write(buffer,0,len);
        }
//        8、将流关闭。
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
