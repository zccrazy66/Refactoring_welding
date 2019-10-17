package com.springboot_vue.js.past;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UploadController {



    @RequestMapping("/picture")
    @ResponseBody
    public Object pic(@RequestParam("picture") MultipartFile picture) throws IOException {

//        接收由前端发来的图片并转换为base64编码
          String contentType = picture.getContentType();
          byte[] imageBytes = picture.getBytes();
          BASE64Encoder base64Encoder = new BASE64Encoder();
          String basecode = base64Encoder.encode(imageBytes);
          basecode = basecode.replaceAll("[\\s*\t\n\r]", "");
          System.out.println(basecode);






          return basecode;



    }





}
