package com.catapultium.assistant.speedQuiz;

import com.catapultium.assistant.speedQuiz.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;

import java.security.Principal;
import java.util.Map;

@Slf4j
@Controller
public class SpeedQuizController {

    @MessageMapping("/echo")
    @SendTo("/topic/echoTest")
    public Message echo(Message message, @Payload String payload, SimpMessageHeaderAccessor headerAccessor) {
        
        String webSocketSessionId = headerAccessor.getSessionId();
        String httpSessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();

        log.debug("webSocketSessionId : " + webSocketSessionId);
        log.debug("httpSessionId : " + httpSessionId);
        
        log.debug("message : " +  message.toString());
        return message;
    }
}
