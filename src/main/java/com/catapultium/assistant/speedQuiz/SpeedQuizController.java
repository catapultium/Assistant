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
    public Message echo(Principal principal, Message message, @Payload String payload, SimpMessageHeaderAccessor headerAccessor)  {
        Map<String, Object> stringObjectMap = headerAccessor.getSessionAttributes();
        String sessionId = headerAccessor.getSessionId();
        log.debug(sessionId);
        log.debug(principal.getName());
        log.debug(message.toString());
        return message;
    }
}
