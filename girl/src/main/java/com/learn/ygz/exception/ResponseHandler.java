package com.learn.ygz.exception;

/**
 * Created by admin on 2017/7/3.

 */
public class ResponseHandler<T> {
    private String message;
    private Integer errorCode;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseHandler logInfo(){
        ResponseHandler responseHandler = new ResponseHandler();




        return null;
    }
}
