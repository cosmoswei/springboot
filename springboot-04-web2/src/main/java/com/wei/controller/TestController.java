package com.wei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/text")
    public String text(Model model){
        model.addAttribute("msg","hello springboot");
        return "text";
    }
}
