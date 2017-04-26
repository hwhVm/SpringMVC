package com.beini.websocket;

import com.beini.utils.BLog;
import org.java_websocket.WebSocket;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by beini on 2017/4/24.
 * 消息处理中心，相当于使用原始J2EE API实现中的@OnMessage和@OnClose注解功能
 */
public class SystemWebSocketHandler implements WebSocketHandler {


    private static final ArrayList<WebSocketSession> users;

    static {
        users = new ArrayList<>();
    }

//    @Autowired
//    private WebSocketService webSocketService;

    /**
     * 初次链接成功执行
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        BLog.d("   SystemWebSocketHandler        connect to the websocket success......  "+(session==null));
//        session.sendMessage(new TextMessage("Server:connected OK!"));
        users.add(session);
    }

    /**
     * 接受消息处理消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        BLog.d("SystemWebSocketHandler         handleMessage");

//        TextMessage returnMessage = new TextMessage(message.getPayload()
//                + " received at server");
//        System.out.println(session.getHandshakeHeaders().getFirst("Cookie"));
//        session.sendMessage(returnMessage);

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        BLog.d("SystemWebSocketHandler      websocket connection closed......");
        users.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        BLog.d(" SystemWebSocketHandler   websocket connection closed......");
        users.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给某个用户发送消息
     *
     * @param userName
     * @param message
     */
    public void sendMessageToUser(String userName, TextMessage message) {
            BLog.d("  给某个用户发送消息 sendMessageToUser");
        for (WebSocketSession user : users) {
            BLog.d("     user.getAttributes().get(\"WEBSOCKET_USERNAME\")="+user.getAttributes().get("WEBSOCKET_USERNAME")+"  userName="+userName);
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    BLog.d("    user.isOpen()="+user.isOpen());
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    BLog.d("   e="+e.getLocalizedMessage());
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
