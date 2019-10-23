package com.backen.vue.Service.Impl;


import com.backen.vue.Service.UtilService;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class UtilServiceImpl implements UtilService {


    @Override
    public Map<String, Object> Classification(Map map) {

        System.out.print("hello?");
        // 返回前段的map
        Map<String,Object> res = new HashMap<String, Object>();

        // 先根据返回来的map取得对应的值
        String error_code =(String) map.get("Semantic_segmentation");

        if (error_code == null){
            int comprehensive_judgement_type = (int) map.get("comprehensive_judgement_type");
            String detect_confidence = (String) map.get("detect_confidence");
            int chengsha_sign = (int) map.get("chengcha_sign");
            int over_cold_welding_sign = (int) map.get("over_cold_welding_sign");
            String over_cold_welding_value = (String) map.get("over_cold_welding_value");
            int impurity_sign = (int) map.get("impurity_sign");
            String impurity_value = (String) map.get("impurity_value");
            int hole_sign = (int) map.get("hole_sign");
            String hole_value = (String) map.get("hole_value");
            int dislocation_sign = (int) map.get("dislocation_sign");
            String dislocation_value = (String) map.get("dislocation_value");
            // 判断缺陷类型和等级
            switch (comprehensive_judgement_type){
                case 1:
                    res.put("comprehensive_judgement_type","承插不到位");
                    break;
                case 2:
                    res.put("comprehensive_judgement_type","冷焊");
                    break;
                case 3:
                    res.put("comprehensive_judgement_type","过焊");
                    break;
                case 4:
                    res.put("comprehensive_judgement_type","融合面夹杂");
                    break;
                case 5:
                    res.put("comprehensive_judgement_type","孔洞");
                    break;
                case 6:
                    res.put("comprehensive_judgement_type","电阻丝错位");
                    break;
            }
            switch (chengsha_sign){
                case 0:
                    res.put("chengcha_sign",null);
                    break;
                case 1:
                    res.put("chengcha_sign","存在承插不到位");
                    break;
            }
            switch (over_cold_welding_sign){
                case 0:
                    res.put("over_cold_welding_sign",null);
                    break;
                case 1:
                    res.put("over_cold_welding_sign","存在一级过焊");
                    break;
                case 2:
                    res.put("over_cold_welding_sign","存在二级过焊");
                    break;
                case 3:
                    res.put("over_cold_welding_sign","存在三级过焊");
                    break;
                case 4:
                    res.put("over_cold_welding_sign","存在一级冷焊");
                    break;
                case 5:
                    res.put("over_cold_welding_sign","存在二级冷焊");
                    break;
                case 6:
                    res.put("over_cold_welding_sign","存在三级冷焊");
                    break;
            }
            switch (impurity_sign){
                case 0:
                    res.put("impurity_sign",null);
                    break;
                case 1:
                    res.put("impurity_sign","存在油污夹杂");
                    break;
                case 2:
                    res.put("impurity_sign","存在金属夹杂");
                    break;
            }
            switch (hole_sign){
                case 0:
                    res.put("hole_sign",null);
                    break;
                case 1:
                    res.put("hole_sign","存在一级单个孔洞");
                    break;
                case 2:
                    res.put("hole_sign","存在二级单个孔洞");
                    break;
                case 3:
                    res.put("hole_sign","存在三级单个孔洞");
                    break;
                case 4:
                    res.put("hole_sign","存在一级组合孔洞");
                    break;
                case 5:
                    res.put("hole_sign","存在二级组合孔洞");
                    break;
                case 6:
                    res.put("hole_sign","存在三级组合孔洞");
                    break;
            }
            switch (dislocation_sign){
                case 0:
                    res.put("dislocation_sign",null);
                    break;
                case 1:
                    res.put("dislocation_sign","存在一级错位");
                    break;
                case 2:
                    res.put("dislocation_sign","存在二级错位");
                    break;
                case 3:
                    res.put("dislocation_sign","存在三级错位");
                    break;
            }

            res.put("over_cold_welding_value",over_cold_welding_value);
            res.put("impurity_value",impurity_value);
            res.put("hole_value",hole_value);
            res.put("dislocation_value",dislocation_value);
            res.put("comprehensive_judgement_level",map.get("comprehensive_judgement_level").toString());
            res.put("image",map.get("image").toString());
            res.put("detect_confidence",detect_confidence);

            return res;
        }
        else {
            res.put("error_code",error_code);
            return res;
        }

    }

}
