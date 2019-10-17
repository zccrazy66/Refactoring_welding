package com.springboot_vue.js.Dao;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PermissionDao {

    JSONObject getUserPermission (@Param("username") String username);

    /**
     * 查询所有的菜单
     */

    Set<String> getAllMenu();

    /**
     * 查询所有的权限
     */
    Set<String> getAllPermission();



}
