package com.utm.cs.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BaseControllers {
    @GetMapping("/")
    public String loadWelcome(){
        return "welcome";
    }

    @GetMapping("/about")
    public String loadAbout(){
        return "about";
    }
}
