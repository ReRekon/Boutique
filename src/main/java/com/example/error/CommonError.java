package com.example.error;

/**
 * @Author zuojh
 * @date 2019/7/31 12:14
 */
public interface CommonError {
    public int getErrorCode();
    public String getErrorMsg();
    public CommonError setErrorMsg(String errorMsg);
}
