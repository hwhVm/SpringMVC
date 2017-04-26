package com.beini.controller;

import com.beini.utils.BLog;
import com.beini.websocket.SystemWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by beini on 2017/4/24.
 */
@Controller
@RequestMapping("/")
public class WebSocketContorller {

    @RequestMapping("gotoWebSocket")
    public String gotoWebSocket() {
        return " websocket";
    }

    @Bean
    public SystemWebSocketHandler systemWebSocketHandler() {
        return new SystemWebSocketHandler();
    }

    @RequestMapping("webSocketSaveSession")
    public void webSocketSaveSession(HttpServletRequest request, HttpServletResponse response  , HttpSession session, PrintWriter printWriter) {
        String str = (String) session.getAttribute("userId");
        BLog.d("    str=="+str);
        printWriter.write("success ");
    }

    @RequestMapping("auditing")
    @ResponseBody
    public void auditing(HttpServletRequest request) {
        BLog.d("        auditing   " + (systemWebSocketHandler() == null));
        systemWebSocketHandler().sendMessageToUser("WEBSOCKET_USERNAME", new TextMessage("dddddddddd"));
    }
}
