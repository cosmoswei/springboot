package com.wei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在templates目录下的页面，只能通过Controller跳转,需要模板引擎（thymeleaf）的支持
@Controller
public class IndexController {
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "<h1>hello thymeleaf</h1>");
        model.addAttribute("user", Arrays.asList("黄旭伟大", "宇宙伟大"));
        return "test";
    }
}
