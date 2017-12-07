package com.catapultium.assistant.speedQuiz;

import com.catapultium.assistant.speedQuiz.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class SpeedQuizController {

    @MessageMapping("/echo") 
    @SendTo("/topic/echoTest")
    public Message echo(Message message) {
        log.debug(message.toString());
        return message;
    }
}
