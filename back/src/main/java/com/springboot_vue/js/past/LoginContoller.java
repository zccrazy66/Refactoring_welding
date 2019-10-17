package com.springboot_vue.js.past;


import com.alibaba.fastjson.JSONObject;
import com.springboot_vue.js.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginContoller {


    @Autowired
    private LoginService loginService;

    /**
     * 登录
     */

    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
//        CommonUtil.hasAllRequired(requestJson, "username,password");

//        System.out.println("controller");
        JSONObject a = loginService.authLogin(requestJson);

        System.out.println(a);
        return a;
    }

    /**
     * 查询当前登录用户的信息
     *
     */

    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     */

    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }



}
