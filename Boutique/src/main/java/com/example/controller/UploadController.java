package com.example.controller;

import com.example.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：
 * @ClassName ：UploadController
 * @date : 2019/4/1 17:47
 * @description : TODO
 */
@RestController
@RequestMapping("/upload")
//@Api(tags = "图片上传接口")
public class UploadController {


    @Autowired
    private UploadService uploadService;

    @Value("${baseUploadUrl}")
    private String url;

    @PostMapping(value = "/uploadImg")
//    @ApiOperation(value = "单个图片上传到七牛云")
    public String uploadImg(@RequestParam(value = "file")MultipartFile upfile) throws IOException {
        Map<String,Object> map = new HashMap<>();
        String fileName = upfile.getOriginalFilename();
        File file = new File(url + fileName);
        try{
            //将MulitpartFile文件转化为file文件格式
            upfile.transferTo(file);
            Map response = uploadService.uploadFile(file);
            Object imageName = response.get("imgName");
            map.put("url",imageName);
            map.put("state","SUCESS");
        }catch (Exception e){
            e.printStackTrace();
        }
        String Imgurl = null;
        Imgurl = "http://pv2vvw8an.bkt.clouddn.com/"+map.get("url");
        return Imgurl;
    }
}
