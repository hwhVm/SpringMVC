package com.beini.websocket;

import com.beini.utils.BLog;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by beini on 2017/4/24.
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    /**
     * 拦截器（握手）
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @param webSocketHandler
     * @param map
     * @return
     * @throws Exception
     */

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        BLog.d("         beforeHandshake ");
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;

            HttpSession session = servletRequest.getServletRequest().getSession(false);
            BLog.d("    session=null?=   "+(session==null));
            if (session != null) {
                //使用userName区分WebSocketHandler，以便定向发送消息
                String userName = (String) session.getAttribute("SESSION_USERNAME");
                BLog.d("   SESSION_USERNAME     userName= "+userName);
                map.put("WEBSOCKET_USERNAME",userName);
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        BLog.d("    WebSocketHandshakeInterceptor     afterHandshake");
    }
}
