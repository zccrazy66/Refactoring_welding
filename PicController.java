package com.backen.vue.Controller;


import com.backen.vue.Service.FlaskService;
import com.backen.vue.Service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PicController {


    @Autowired
    FlaskService flaskService;

    @Autowired
    UtilService utilService;



    @RequestMapping("/picture")
    @ResponseBody
    public Object pic(@RequestParam("picture") MultipartFile picture, @RequestParam Map<String,String> inmap) throws IOException {

        double length_test = Double.parseDouble(inmap.get("test_length"));
        System.out.println(length_test);

//        接收由前端发来的图片并转换为base64编码
        String contentType = picture.getContentType();
        byte[] imageBytes = picture.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String basecode = encoder.encodeToString(imageBytes);
        basecode = basecode.replaceAll("[\\s*\t\n\r]", "");
//        System.out.println(basecode);
//        把接受到的base64码和给的特征线到电阻丝距离传给算法端进行识别
//        double length_test = 10.0;
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("imageBase64",basecode);
        map.put("distance_feature_and_resistance", length_test);
        Map rlt = flaskService.post_flask(map);
//        对返回来的数据处理一下再返给前端
        System.out.print("rlt is that" + rlt);
        Map res = utilService.Classification(rlt);
//        System.out.print("the res is that" + res);

        return res;



    }





}
