package com.example.mapper;

import com.qiniu.common.QiniuException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Map;

@Repository
public interface UploadMapper {
    /**
     * @Author :
     * @Description : //TODO 多文件上传
     * @Date : 10:04 2019/4/3
     * @Param :
     * @return :
     **/
    Map uploadFile(File file) throws QiniuException;
}