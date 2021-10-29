package com.wei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplication这是一个spring boot应用:启动下类所有资源被导入
@SpringBootApplication
public class Springboot01HelloApplication {
    //    将springboot启动
    public static void main(String[] args) {
        SpringApplication.run(Springboot01HelloApplication.class, args);
    }

}
