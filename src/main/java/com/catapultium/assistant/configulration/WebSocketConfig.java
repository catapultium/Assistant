package com.catapultium.assistant.configulration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer implements WebSocketConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        String appAddress = "/assistant";
        String topicAddress = "/topic";
        registry.enableSimpleBroker(topicAddress);
        registry.setApplicationDestinationPrefixes(appAddress);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/webSocket")
                .setHandshakeHandler(new AnonymousUserHandShakeHandler())
                .withSockJS();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SimpleHandler(), "/servus");
    }

    private class SimpleHandler extends TextWebSocketHandler {
        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            super.handleTextMessage(session, message);
            session.sendMessage(new TextMessage("Hi there, " + message.getPayload() + "!"));
        }
    }
}
