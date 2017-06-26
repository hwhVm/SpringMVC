package com.beini.test.javase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by beini on 2017/6/24.
 */
public class ServiceMain {
    private static ExecutorService fixedThreadPool;//支持请求数
    private static Robot robot;

    public static void main(String[] args) throws IOException, AWTException {
        fixedThreadPool = Executors.newFixedThreadPool(5);
        robot = new Robot();
        //设置Robot产生一个动作后的休眠时间,否则执行过快
        robot.setAutoDelay(1000);

        System.out.println("begin...........");
        try {
            ServerSocket ss = new ServerSocket(10000);
            while (true) {
                Socket s = ss.accept();
                //接收客户端的信息
                InputStream is = s.getInputStream();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                String message = br.readLine();
                System.out.println("  接收客户端的信息---------11111111--------->" + message);
                if (message != null) {
                    System.out.println("  接收客户端的信息------------------>" + message);
                    if ("0".equals(message)) {
                        screenShot();
                    } else if ("1".equals(message)) {
                        moveMouse();
                    } else if ("2".equals(message)) {
                        clickLeft();
                    } else if ("3".equals(message)) {
                        clickRight();
                    } else if ("4".equals(message)) {
                        pressEsc();
                    } else if ("5".equals(message)) {
                        rollMouse();
                    } else if ("6".equals(message)) {
                        pressAltTAB();
                    }
                }
                //返回客户端的信息
                OutputStream os = s.getOutputStream();
                os.write("0".getBytes("utf-8"));
                os.close();
                s.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        System.out.println("end.......................");
    }

    private static void screenShot() throws AWTException, IOException {//0
        //获取屏幕分辨率
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRect = new Rectangle(d);
        //截图（截取整个屏幕图片）
        BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
        //保存截图
        File file = new File("C:\\Users\\Administrator\\Desktop\\screenRect.png");
        ImageIO.write(bufferedImage, "png", file);
    }

    private static void moveMouse() { //移动鼠标  1
        robot.mouseMove(500, 500);
    }

    private static void clickLeft() {  //点击鼠标左键 2
        System.out.println("单击");
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    private static void clickRight() {   //点击鼠标右键  3
        System.out.println("右击");
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    private static void pressEsc() { //按下ESC，退出右键状态 4
        System.out.println("按下ESC");
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    private static void rollMouse() {//滚动鼠标滚轴  5
        System.out.println("滚轴");
        robot.mouseWheel(5);
    }

    private static void pressAltTAB() {         //按下Alt+TAB键（切换桌面窗口）   6
        robot.keyPress(KeyEvent.VK_ALT);
        for (int i = 1; i <= 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        robot.keyRelease(KeyEvent.VK_ALT);
    }
}
