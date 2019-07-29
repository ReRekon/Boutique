package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.service.impl.SpecificationImageServiceImpl;
import com.example.entity.SpecificationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/SpecificationImage")
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
    public int delete(@RequestParam("specificationImageId")int specificationImageId){
        return specificationImageService.delete(specificationImageId);
    }

    @RequestMapping("/updateSpecificationImage")
    @ResponseBody
    public int update(@Valid SpecificationImage specificationImage){
        return specificationImageService.update(specificationImage);
    }

    @RequestMapping("/getSpecificationImage")
    @ResponseBody
    public String getSpecificationImage(@RequestParam("specificationImageId") int specificationImageId){
        List<SpecificationImage> specificationImageList = specificationImageService.findAll(specificationImageId);
        //System.out.println(specificationImageService.findAll(specificationImageId)+"########");
        return JSONObject.toJSONString(specificationImageList);
    }
}
