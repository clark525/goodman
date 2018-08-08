package com.hangc.goodman.websocket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


/**
 * socket握手拦截.
 * including.
 */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {


    /**
     * before方法.
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
                                   ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {

        if (request.getHeaders().containsKey("Sec-WebSocket-Extensions")) {
            request.getHeaders().set("Sec-WebSocket-Extensions", "permessage-deflate");
        }
        System.out.println("++++++++++++++++ HandshakeInterceptor: beforeHandshake  ++++++++++++++" + attributes);

        return super.beforeHandshake(request, response, wsHandler, attributes);
    }


    /**
     * show 方法的简述.
     * ＜p＞show 方法的详细说明第一行＜br＞
     * show 方法的详细说明第二行
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param ex
     */
    @Override
    public void afterHandshake(ServerHttpRequest request,
                               ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception ex) {


        System.out.println("++++++++++++++++ HandshakeInterceptor: afterHandshake  ++++++++++++++");


        super.afterHandshake(request, response, wsHandler, ex);
    }

}
