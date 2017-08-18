package com.ygz.learn.spring.ioc.service;

import com.ygz.learn.spring.ioc.entity.UserEntity;

import java.util.List;

/**
 * Created by admin on 2017/8/14.
 */
public interface UserService {
    void saveUser(UserEntity userEntity);
    List getUser(String id);
}
