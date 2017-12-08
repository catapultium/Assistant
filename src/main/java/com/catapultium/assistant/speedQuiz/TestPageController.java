package com.catapultium.assistant.speedQuiz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@Slf4j
public class TestPageController {
    @RequestMapping("/dummy")
    public String dummyPage (){
        String session = RequestContextHolder.currentRequestAttributes().getSessionId();
        log.debug(session);
        return "echoTest";
    }
}
