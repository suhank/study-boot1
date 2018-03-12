package com.zccoder.boot1.ch7.web.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.List;

/**
 * @title 配置类
 * @describe WebSocket配置
 * // 通过 @EnableWebSocketMessageBroker 注解开启使用 STOMP 协议来传输基于代理（message broker）的消息，这时控制器支持
 * // 使用 @MessageMapping，就像使用 @RequestMapping一样。
 * @author zc
 * @date 2018/03/12
 **/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    /**
     * // 注册 STOMP 协议的节点（endpoint），并映射指定的URL。
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        // 注册一个 STOMP 的endpoint，并指定使用 SockJS 协议。
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();
        // 注册一个名为 /endpointChat
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS();
    }

    /**
     * // 配置消息代理（Message Broker）。
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 广播式应配置一个/topic消息代理。
        // 点对点式应增加一个/queue消息代理。
        registry.enableSimpleBroker("/queue","/topic");
    }
}
