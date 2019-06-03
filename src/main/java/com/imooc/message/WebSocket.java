package com.imooc.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created with IDEA
 * author:ChenSuoZhang
 * Date:2019/6/1 0001
 * Time:21:40
 * Desc
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
        log.info("【websocket消息】 有新的连接，总数:{}",webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);
        log.info("【websocket消息】 连接d断开，总数:{}",webSockets.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("【websocket消息】收到客户端发来的信息:{}",message);
    }

    public void sendMessage(String message){
        for (WebSocket webSocket : webSockets){
            try {
                log.info("【websocket消息】发送信息:{}",message);
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                log.info("【websocket消息】发生错误:{}",e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
