package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.impl.SpecificationImageServiceImpl;
import com.example.entity.SpecificationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/SpecificationImage")
@CrossOrigin(origins = "*",maxAge = 3600)
public class SpecificationImageController {

    @Autowired
    private SpecificationImageServiceImpl specificationImageService;

    @RequestMapping("/addSpecificationImage")
    @ResponseBody
    public int add(@Valid SpecificationImage specificationImage){
        specificationImageService.add(specificationImage);
        //主键回填
        return specificationImage.getSpecificationImageId();
    }

    @RequestMapping("/deleteSpecificationImage")
    @ResponseBody
    public int delete(@RequestBody int specificationImageId){
        return specificationImageService.delete(specificationImageId);
    }

    @RequestMapping("/updateSpecificationImage")
    @ResponseBody
    public int update(@Valid SpecificationImage specificationImage){
        return specificationImageService.update(specificationImage);
    }

    @RequestMapping("/getSpecificationImage")
    @ResponseBody
    public String getSpecificationImage(@RequestBody int productId){
        List<SpecificationImage> specificationImageList = specificationImageService.findAll(productId);
        //System.out.println(specificationImageService.findAll(specificationImageId)+"########");
        return JSONObject.toJSONString(specificationImageList);
    }
}
