package com.japStudy.ssafyStudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@ResponseBody
//@RestController
@Slf4j
public class HomeController {
//    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/")
    public String home() {

        log.info("home controller");
        return "home";
    }
}
