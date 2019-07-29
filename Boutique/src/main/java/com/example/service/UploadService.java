package com.example.service;

import com.qiniu.common.QiniuException;

import java.io.File;
import java.util.Map;

public interface UploadService {

    public Map uploadFile(File file) throws QiniuException;
}
