package com.catapultium.assistant.speedQuiz;

import com.catapultium.assistant.speedQuiz.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Slf4j
@Controller
public class SpeedQuizController {

    @MessageMapping("/echo") 
    @SendTo("/topic/echoTest")
    public Message echo(Principal principal, Message message)  {
        log.debug(principal.getName());
        log.debug(message.toString());
        return message;
    }
}
