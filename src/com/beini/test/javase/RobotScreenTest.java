package com.beini.test.javase;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by beini on 2017/6/26.
 * Robot实现监控屏幕,实现效果是每隔50微秒获取当前屏幕图像，显示到JFrame内
 */
public class RobotScreenTest {


    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        Robot robot = new Robot();
        JFrame jframe = new JFrame();
        //设置标题
        jframe.setTitle("wangtianze监控屏幕工具");
        JLabel label = new JLabel();
        jframe.add(label);
        jframe.setSize(800, 600);
        //设置可见
        jframe.setVisible(true);
        //设置置顶
        jframe.setAlwaysOnTop(true);
        //控制台退出模式
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dm = toolkit.getScreenSize();
        while (true) {
            //一个矩形面板
            Rectangle rec = new Rectangle(0, 0, (int) dm.getWidth(), (int) dm.getHeight());
            //按照矩形截取图片到缓冲流
            BufferedImage img = robot.createScreenCapture(rec);
            //缩放图片
            BufferedImage newImg = RobotScreenTest.resize(img, jframe.getWidth(), jframe.getHeight());
            label.setIcon(new ImageIcon(newImg));
            Thread.sleep(50);

        }


    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        //创建一个缩放后的图片流
        BufferedImage newImg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = newImg.createGraphics();
        //设置模式
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        //按比例缩放
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return newImg;
    }

}
