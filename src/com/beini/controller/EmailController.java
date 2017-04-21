package com.beini.controller;

import com.beini.utils.BLog;
import com.beini.utils.SendEMail;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by beini on 2017/4/21.
 */
@Controller
@RequestMapping("/")
public class EmailController {
    private String host = "smtp.126.com";
    private int port = 25;
    private String email = "divoom_gz@126.com";
    private String password = "divoom1234";

    /**
     * 找回密码 验证码+邮箱
     */
    @RequestMapping("sendEmail")
    public void sendEmail(HttpServletRequest request) {
       //查找数据库是否存在改用户邮箱

        //发送验证连接

        SendEMail mail = new SendEMail(host, port, email, password);
        List<String> files = new ArrayList<>();
        List<String> toEmail = new ArrayList<>();
        toEmail.add(email);
        List<String> ccEmail = new ArrayList<>();
        String title = "dddddd";
        String content = "ddddddd";
        mail.setParams(toEmail, ccEmail, title, content, files);
        mail.setJieEmailInfterface(new SendEMail.JieEmailInfterface() {
            @Override
            public void startSend() {
                BLog.d("-------------->开始发邮件");
            }

            @Override
            public void SendStatus(SendEMail.SendStatus sendStatus) {
                switch (sendStatus) {
                    case SENDING:
                        BLog.d("      SENDING ");
                        break;
                    case UNDO:
                        BLog.d("      UNDO ");
                        break;
                    case SENDOK:
                        BLog.d("      END OK ");
                        break;
                    case SENDFAIL:
                        BLog.d("      SEND FAIL");
                        break;
                }
            }
        });
        mail.sendEmail();
    }
}
