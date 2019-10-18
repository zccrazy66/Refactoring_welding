package com.springboot_vue.js.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot_vue.js.Dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/api")
public class DatashowController {

    @Autowired
    DataDao dataDao;


    @RequestMapping("/data")
    @ResponseBody
    public List<JSONObject> show_data(){
        List<JSONObject> test = dataDao.alist();
        System.out.println(test);
        return test;
    }

}
