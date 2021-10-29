package com.wei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author cosmoswei
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/jdbc")
    public List<Map<String, Object>> jdbcTest() {
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
        return maps;
    }
}
