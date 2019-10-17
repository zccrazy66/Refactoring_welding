package com.springboot_vue.js.Service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService {


    JSONObject getUser(String name ,String password);

    JSONObject authLogin(JSONObject jsonObject);

    JSONObject getInfo();


    /**
     *
     *登出
     *
     */


    JSONObject logout();


}
