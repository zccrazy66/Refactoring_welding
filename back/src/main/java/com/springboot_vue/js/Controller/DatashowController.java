package com.springboot_vue.js.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class DatashowController {

//    Autowired



    @RequestMapping("/data")
    @ResponseBody
    public JSONObject show_data(){

//          Map<String,Object> map = new HashMap<>();
//          map.put("test1" , "get it right");
//        String t = "here we are";
        String str = "{\"age\":\"24\"}";
        JSONObject  jsonObject = JSONObject.parseObject(str);

        return jsonObject;
    }

}
