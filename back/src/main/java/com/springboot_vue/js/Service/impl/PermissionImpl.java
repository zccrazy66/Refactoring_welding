package com.springboot_vue.js.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springboot_vue.js.Dao.PermissionDao;
import com.springboot_vue.js.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PermissionImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    /**
     * 查询某用户的 角色  权限
     */
    @Override
    public JSONObject getUserPermission(String username) {
        System.out.println("************");

        JSONObject userPermission = getUserPermissionFromDB(username);

        System.out.println("getUserPermission ... is" + userPermission);

        return userPermission;
    }

    /**
     * 从数据库查询用户权限信息
     */
    private JSONObject getUserPermissionFromDB(String username) {

//        System.out.println("here is a private");

        JSONObject userPermission = permissionDao.getUserPermission(username);
        //管理员角色ID为1
        int adminRoleId = 1;
//        如果是管理员
        String roleIdKey = "roleId";
        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
            //查询所有菜单  所有权限
            Set<String> menuList = permissionDao.getAllMenu();
            Set<String> permissionList = permissionDao.getAllPermission();
            userPermission.put("menuList", menuList);
            userPermission.put("permissionList", permissionList);
        }

        System.out.println(userPermission);

        return userPermission;
    }





}
