package com.example.demo.controller;

import com.example.demo.vo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.HashMap;

@Controller
@RequestMapping("/api")
public class HelloController {
    /**
     * Welcome을 반환한다.
     * 
     * @return Welcome
     */
    @GetMapping("/welcome")
    @ResponseBody
    public String apiWelcome() {
        return "Welcome";
    }

    /**
     * Welcome을 JSON 형태로 반환한다.
     * 
     * @return {"message": "Welcome"}
     */
    @GetMapping("/json")
    @ResponseBody
    public Map<String, String> apiJson() {
        final Map<String, String> map = new HashMap<>();
        map.put("message", "Welcome");
        return map;
    }
}

