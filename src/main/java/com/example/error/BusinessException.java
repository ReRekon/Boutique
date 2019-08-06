package com.example.error;

/**
 * @Author zuojh
 * @date 2019/7/31 12:25
 */
//包装器业务异常类实现
public class BusinessException extends Exception implements CommonError {
    private CommonError commonError;
    //直接接收EmBasiness的传参用于构造业务异常
    public BusinessException(CommonError commonError){
        super();
        this.commonError=commonError;
    }
    //接收自定义errMsg的方式构造义务异常
    public BusinessException(CommonError commonError,String message) {
        super();
        this.commonError = commonError;
        this.setErrorMsg(message);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.commonError.setErrorMsg(errorMsg);
        return this;
    }
}