package com.springboot_vue.js.Dao;


import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginDao {

    JSONObject getUser(@Param("username") String username, @Param("password") String password);

}

