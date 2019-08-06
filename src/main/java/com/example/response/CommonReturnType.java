package com.example.response;

/**
 * @Author zuojh
 * @date 2019/7/31 12:02
 */
public class CommonReturnType {
    //status表明对应请求返回处理结果“success”或者“false”
    private String status;
    //若status==success 则data对应前端需要的json
    //若status==false 则data返回通用的错误码格式
    private Object data;

    //定义通用的创建方法
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }
    public static CommonReturnType create(Object result,String status){
        CommonReturnType type = new CommonReturnType();
        type.setData(result);
        type.setStatus(status);
        return type;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}