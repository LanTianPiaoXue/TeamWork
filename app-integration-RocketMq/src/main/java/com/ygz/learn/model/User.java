package com.ygz.learn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/8/23.
 */
public class User {
    private final Logger logger = LoggerFactory.getLogger(User.class);

    private String userName;
    private String pwd;
    private  Integer id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        logger.info("set userName:"+userName);
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        logger.info("set pwd:"+pwd);
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        logger.info("set id:"+id);
        this.id = id;
    }
}
