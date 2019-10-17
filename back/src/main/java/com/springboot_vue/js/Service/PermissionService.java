package com.springboot_vue.js.Service;

import com.alibaba.fastjson.JSONObject;

public interface PermissionService {

    JSONObject getUserPermission(String username);


}
