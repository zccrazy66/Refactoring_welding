package com.springboot_vue.js.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot_vue.js.Dao.LoginDao;
import com.springboot_vue.js.Service.LoginService;
import com.springboot_vue.js.Service.PermissionService;
import com.springboot_vue.js.util.CommonUtil;
import com.springboot_vue.js.util.constants.constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.shiro.subject.Subject;



@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    @Autowired
    PermissionService permissionService;


    @Override
    public JSONObject getUser(String username, String password) {

        System.out.println("into getUser");


        return loginDao.getUser(username, password);
    }



//    提交表单

    @Override
    public JSONObject authLogin(JSONObject jsonObject) {

        System.out.println("into authLogin");

        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject info = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

//        System.out.println(token);

        try{
            currentUser.login(token);
            info.put("msg", "success");
            info.put("token", username);
        }catch (AuthenticationException e){
            info.put("msg","fail");
        }

        System.out.println(info);

        return CommonUtil.successJson(info);
    }

    @Override
    public JSONObject getInfo() {

//      从session获取用户信息

        Session session = SecurityUtils.getSubject().getSession(); // 通过 shiro获取 session
        JSONObject userInfo = (JSONObject) session.getAttribute(constants.SESSION_USER_INFO);

//        System.out.println(userInfo);

        String username = userInfo.getString("username");
        JSONObject info = new JSONObject();

        JSONObject userPermission = permissionService.getUserPermission(username);
        session.setAttribute(constants.SESSION_USER_PERMISSION, userPermission);
        info.put("userPermission", userPermission);
        return CommonUtil.successJson(info);

    }

    @Override
    public JSONObject logout() {

        System.out.println("into logout");

        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e){

        }
        return CommonUtil.successjson();
    }
}
