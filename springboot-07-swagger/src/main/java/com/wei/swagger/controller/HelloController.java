package com.wei.swagger.controller;

import com.wei.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation("hello控制类")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/user")
    public User user() {
        return new User("黄旭伟","123456");
    }
}
