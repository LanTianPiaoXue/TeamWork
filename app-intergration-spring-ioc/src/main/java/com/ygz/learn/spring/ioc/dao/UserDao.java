package com.ygz.learn.spring.ioc.dao;

import com.ygz.learn.spring.ioc.entity.UserEntity;

import java.util.List;

/**
 * Created by admin on 2017/8/14.
 */
public interface UserDao {
    void saveUser(UserEntity userEntity);
    List<UserEntity> getUser(String id);
}
