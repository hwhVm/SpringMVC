package com.beini.websocket;

import com.beini.utils.BLog;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;

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
        BLog.d("connect to the websocket success......");
        users.add(session);
//        String userName = (String) session.getAttributes().get(Constants.WEBSOCKET_USERNAME);
        String userName = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        if (userName != null) {
            //查询未读消息
//            int count = webSocketService.getUnReadNews((String) session.getAttributes().get(Constants.WEBSOCKET_USERNAME));
//            int count = webSocketService.getUnReadNews((String) session.getAttributes().get("WEBSOCKET_USERNAME"));
            int count = 0;
            session.sendMessage(new TextMessage(count + ""));
        }
    }

    /**
     * 接受消息处理消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        BLog.d("handleMessage");
        //sendMessageToUsers();
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        BLog.d("websocket connection closed......");
        users.remove(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        BLog.d("websocket connection closed......");
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
        for (WebSocketSession user : users) {
            if (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) {
                try {
                    if (user.isOpen()) {
                        user.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
