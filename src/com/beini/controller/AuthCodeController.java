package com.beini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Random;

/**
 * Created by beini on 2017/4/20.
 */
@Controller("/")
public class AuthCodeController {
    /**
     * 验证码
     * http://blog.csdn.net/duan9421/article/details/50599119
     * http://blog.csdn.net/quincylk/article/details/51589714
     *
     * @param request
     * @param response
     */

    @RequestMapping(value = "getAuthCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("     getAuthCode " + "  session.getId()==" + session.getId() + "   ");
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman", 0, 28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for (int i = 0; i < 40; i++) {
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        System.out.println("  " + request.getSession().hashCode());
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();
    }

    //创建颜色
    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     *
     */

    @RequestMapping("isTrueCode")
    public void yanzhengCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(" --------->btn_yan_zheng  " + session.getCreationTime() + "   " + session.getId() + "   ");

        Enumeration<String> enumeration = session.getAttributeNames();
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());

        String str = request.getParameter("code");
        System.out.println("  str==" + str);
        String string = "FAIL";

        System.out.println("   session.getAttribute(\"strCode\")=" + session.getAttribute("strCode"));

        if (str != null && str.equals(request.getSession().getAttribute("strCode"))) {
            string = "SUCCESS";
        } else {
            string = "FAIL";
        }

//        PrintWriter printWriter;
//        try {
//            printWriter = response.getWriter();
//            printWriter.write(string);
//            printWriter.flush();
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


}
