package com.learn.ygz.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GirlExcepotion extends RuntimeException{
    Logger logger = LoggerFactory.getLogger(GirlExcepotion.class);
    private static ErrorMessage errorMessage;
    public GirlExcepotion(ErrorMessage errorMessage){
        this.errorMessage =errorMessage;
    }

    public  static String getErrorMessage(){
        return errorMessage.getMessage();
    }
}
