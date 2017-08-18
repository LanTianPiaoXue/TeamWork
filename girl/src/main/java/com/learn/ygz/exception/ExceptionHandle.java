package com.learn.ygz.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2017/7/2.
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler
    @ResponseBody
    public  ResponseHandler handle(Exception e){
        return null;
    }
}
