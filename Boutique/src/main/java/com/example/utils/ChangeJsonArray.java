package com.example.utils;

/**
 * @program: Boutique
 * @description: 转化json数组
 * @author: Mr.瑞
 * @create: 2019-08-21 09:29
 **/
public class ChangeJsonArray {

    public static String transform(String string)
    {
        string=string.replace("[","[{");
        string=string.replace("]","}]");
        return string;
    }

}
