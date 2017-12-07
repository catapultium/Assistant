package com.catapultium.assistant.speedQuiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPageController {
    @RequestMapping("/dummy")
    public String dummyPage (){
        return "echoTest";
    }
}
