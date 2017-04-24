package com.beini.test.javase;

import com.beini.utils.BLog;
import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

/**
 * Created by beini on 2017/4/24.
 */
public class SocketServer extends WebSocketServer {
    private static final int PORT = 2333;

    public static void main(String[] args) {
        SocketServer server = new SocketServer(PORT);
        server.start();
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = server.getPort();
            BLog.d("   服务已启动         ip==" + ip + "  port=" + port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public SocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    public SocketServer(InetSocketAddress address) {
        super(address);
    }

    /**
     * 打开连接时触发
     *
     * @param webSocket
     * @param clientHandshake
     */
    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        String address = webSocket.getRemoteSocketAddress().getAddress().getHostAddress();
        String message = String.format("(%s) <加入>", address);
        BLog.d(message);
        broadcastMessage(message);
    }

    /**
     * 关闭连接时触发
     *
     * @param webSocket
     * @param i
     * @param s
     * @param b
     */
    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        String address = webSocket.getRemoteSocketAddress().getAddress().getHostAddress();
        String message = String.format("(%s) <离开>", address);
        broadcastMessage(message);
        BLog.d(message);
    }

    /**
     * 收到客户端消息时触发
     *
     * @param webSocket
     * @param s
     */
    @Override
    public void onMessage(WebSocket webSocket, String s) {
        String address = webSocket.getRemoteSocketAddress().getAddress().getHostAddress();
        BLog.d("      收到客户端消息时触发=+s==" + s);

    }

    @Override
    public void onWebsocketPong(WebSocket conn, Framedata f) {
        super.onWebsocketPong(conn, f);
        BLog.d("pong");
    }

    /**
     * 异常时触发
     *
     * @param webSocket
     * @param e
     */
    @Override
    public void onError(WebSocket webSocket, Exception e) {
        if (null != webSocket) {
            if (!webSocket.isClosed()) {
                webSocket.close(0);
            }
        }
        e.printStackTrace();
    }

    /**
     * 广播收到消息
     * 将数据传回客户端
     *
     * @param msg
     */
    private void broadcastMessage(String msg) {
        BLog.d("     ---->2  ");
        Collection<WebSocket> connections = connections();
        synchronized (connections) {
            for (WebSocket client : connections) {
                client.send(msg);
            }
        }
    }

}
