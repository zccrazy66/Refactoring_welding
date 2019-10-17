package com.springboot_vue.js.past;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//测试传输数据
@Controller
@RequestMapping("/ap")
public class TestController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(/*@RequestBody JSONObject params*/@RequestParam("name") String jj){
        System.out.println("name is "+ jj);
        return jj;
    }


}
