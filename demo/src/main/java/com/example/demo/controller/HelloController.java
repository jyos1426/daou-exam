package com.example.demo.controller;

import com.example.demo.vo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.HashMap;

@Controller
public class HelloController {
    /** * Welcome을 반환한다. * @return Welcome */
    @GetMapping("api/welcome")
    @ResponseBody
    public String apiWelcome() {
        return "Welcome";
    }

    /**
     * Welcome을 JSON 형태로 반환한다.
     * 
     * @return {"message": "Welcome"}
     */
    @GetMapping("api/json")
    @ResponseBody
    public Map<String, String> apiJson() {
        final Map<String, String> map = new HashMap<>();
        map.put("message", "Welcome");
        return map;
    }

    /**
     * 객체를 JSON 형태로 반환한다.
     * 
     * @return {"username": "hyeon"}
     */
    @GetMapping("api/user")
    @ResponseBody
    public User apiUser() {
        final User user = new User();
        // lombok의 @Setter로 사용 가능
        user.setUsername("hyeon");
        return user;
    }


}

