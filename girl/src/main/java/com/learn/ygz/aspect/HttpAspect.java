package com.learn.ygz.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/7/2.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
//    @Pointcut("execution(public * com.learn.ygz.controller.GirlController.insertValidatedGirl(..))")
@Pointcut("execution(public * com.learn.ygz.controller.GirlController.*(..))")
public void log(){
        logger.info("11111111111111111111---Pointcut");
    }

   /* @Before("execution(public * com.learn.ygz.controller.GirlController.insertValidatedGirl(..))")
    public void doBefore(){
        System.out.println("11111111111111111111---before");
    }*/
   @Before("log()")
   public void doBefore(JoinPoint joinPoint){
       logger.info("11111111111111111111---before");
       ServletRequestAttributes attributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       /*request*/
       HttpServletRequest request =  attributes.getRequest();
       /*url*/
       StringBuffer url = request.getRequestURL();
       logger.info("url={}",url);
       /*method*/
       String method = request.getMethod();
       logger.info("method={}",method);
       /*addr*/
       String addr = request.getRemoteAddr();
       logger.info("addr={}",addr);
       /*className*/
       String className = joinPoint.getSignature().getDeclaringTypeName();
       logger.info("className={}",className);

        /*Args*/
       logger.info("Args={}",joinPoint.getArgs());

        /*Signature*/
       logger.info("Args={}",joinPoint.getSignature());
   }

    @After("log()")
    public void doAfter(){
        logger.info("11111111111111111111---After");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
  /* @AfterReturning("log()")
   public void doAfterReturning(){
       logger.info("response={}");
   }*/
}
