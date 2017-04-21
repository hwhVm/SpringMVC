package com.beini.utils;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by beini on 2017/4/21.
 * activation.jar   additionnal.jar   mail.jar
 */
public class SendEMail {
    private int port = 553;  //smtp协议使用的端口
    private String host = "smtp.126.com"; // 发件人邮件服务器
    private String user = "beini@126.com";   // 使用者账号
    private String password = "beini123"; //使用者密码

    private List<String> emailTos;
    private List<String> emailCCs;
    private String subject;
    private String body;
    private List<String> paths;

    public enum SendStatus {
        SENDING, UNDO, SENDOK, SENDFAIL
    }


    private SendStatus sendStatus;

    public interface JieEmailInfterface {
        void startSend();

        void SendStatus(SendStatus sendStatus);
    }

    private JieEmailInfterface jieEmailInfterface;

    public void setJieEmailInfterface(JieEmailInfterface jieEmailInfterface) {
        this.jieEmailInfterface = jieEmailInfterface;
    }


    public SendEMail() {
        sendStatus = SendStatus.UNDO;
    }

    //构造发送邮件帐户的服务器，端口，帐户，密码
    public SendEMail(String host, int port, String user, String password) {
        this.port = port;
        this.user = user;
        this.password = password;
        this.host = host;
        sendStatus = SendStatus.UNDO;
    }

    /**
     * @param emailTos 主要接收人的电子邮箱列表
     * @param emailCCs 抄送人的电子邮箱列表
     * @param subject  邮件标题
     * @param body     正文内容
     * @param paths    发送的附件路径集合
     */
    public void setParams(List<String> emailTos, List<String> emailCCs, String subject, String body,
                          List<String> paths) {
        this.emailTos = emailTos;
        this.emailCCs = emailCCs;
        this.subject = subject;
        this.body = body;
        this.paths = paths;
    }

    /**
     * 开始发送
     */
    public void sendEmail() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                if (jieEmailInfterface != null) {
                    jieEmailInfterface.startSend();
                }
                try {
                    sendStatus = SendStatus.SENDING;
                    sendEmailBg();
                    sendStatus = SendStatus.SENDOK;
                } catch (Exception e) {
                    sendStatus = SendStatus.SENDFAIL;
                    e.printStackTrace();
                }

                if (jieEmailInfterface != null) {
                    jieEmailInfterface.SendStatus(sendStatus);
                }
                sendStatus = SendStatus.UNDO;

            }
        }.start();

    }


    private void sendEmailBg() throws Exception {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");//true一定要加引号
        properties.put("mail.transport.protocol", "smtp");

        JieAuthenticator jieAuth = new JieAuthenticator(user, password);

        Session session = Session.getInstance(properties, jieAuth);
//创建一个消息
        MimeMessage msg = new MimeMessage(session);

//设置发送人
        msg.setFrom(new InternetAddress(user));

//设置主要接收人
        if (emailTos != null && !emailTos.isEmpty()) {
            int size = emailTos.size();
            InternetAddress[] addresses = new InternetAddress[size];
            for (int i = 0; i < size; i++) {
                addresses[i] = new InternetAddress(emailTos.get(i));
            }
            msg.setRecipients(Message.RecipientType.TO, addresses);
        }

//设置抄送人的电子邮件
        if (emailCCs != null && !emailCCs.isEmpty()) {
            int size = emailCCs.size();
            InternetAddress[] addresses = new InternetAddress[size];
            for (int i = 0; i < size; i++) {
                addresses[i] = new InternetAddress(emailCCs.get(i));
            }
            msg.setRecipients(Message.RecipientType.CC, addresses);
        }

        msg.setSubject(subject);

//创建一个消息体
        MimeBodyPart msgBodyPart = new MimeBodyPart();
        msgBodyPart.setText(body);

//创建Multipart增加其他的parts
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(msgBodyPart);

//创建文件附件
        for (String path : paths) {
            MimeBodyPart fileBodyPart = new MimeBodyPart();
            fileBodyPart.attachFile(path);
            mp.addBodyPart(fileBodyPart);
        }

//增加Multipart到消息体中
        msg.setContent(mp);
//设置日期
        msg.setSentDate(new Date());
//设置附件格式
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);
//发送消息
        Transport.send(msg);
    }

    class JieAuthenticator extends Authenticator {
        private String strUser;
        private String strPwd;

        public JieAuthenticator(String user, String password) {
            this.strUser = user;
            this.strPwd = password;
        }


        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(strUser, strPwd);
        }
    }


}
