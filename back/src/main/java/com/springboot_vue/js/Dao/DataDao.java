package com.springboot_vue.js.Dao;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DataDao {

    /**
     * 查询数据库中的所有数据
     * @return
     */

    List<JSONObject> alist ();


}
