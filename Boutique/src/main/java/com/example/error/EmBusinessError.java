package com.example.error;

/**
 * @Author zuojh
 * @date 2019/7/31 12:16
 */
public enum EmBusinessError implements CommonError {
    //通用错误类型10001开头
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKONWN_ERROR(10002,"未知错误"),


    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在"),
    USER_NAME_SAME(20002,"用户名已存在"),
    USER_TEL_SAME(20003,"手机号已被注册"),
    USER_LOGIN_FAIL(20004,"用户名或密码不正确"),
    PASSWORD_FAIL(20005,"密码错误"),

    ;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;
    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.errMsg = errorMsg;
        return this;
    }
}
