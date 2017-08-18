package com.learn.ygz.exception;

/**
 * Created by admin on 2017/7/2.
 */
public enum ErrorMessage {
    SUCCESS_MSG(200,"正常"),
    FAIL_PRIMARY(101,"未成年")
    ;
    private String message;
    private  Integer errorCode;

    ErrorMessage( Integer errorCode,String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

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
}
