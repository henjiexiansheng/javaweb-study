package com.henjie.servlet;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器5秒刷新1次
        resp.setHeader("refresh","3");
        //在内存中创建图片对象（只有长宽的图片）
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();     //2d画笔
        //设置图片的背景颜色
        graphics.setColor(Color.white);     //第一次给背景设置颜色
        graphics.fillRect(0,0,80,20);   //设置形状为矩形
        //给图片写数据
        graphics.setColor(Color.BLUE);      //第2次给文字设置颜色
        graphics.setFont(new Font(null,Font.BOLD,20));  //设置字体
        graphics.drawString(makeNum(),0,20);    //把随机数画入矩形

        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        //网站存在缓存，不让浏览器缓存
        resp.addDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片写给浏览器
        boolean write = ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    //生成随机数
    private String makeNum(){
        Random random = new Random();   //创建随机数
        String num = random.nextInt(999999) + ""; //创建一个6位随机数，并转换为字符串
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6-num.length(); i++) {
            sb.append("0");
        }
        String s = sb.toString() + num;
        return num;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
