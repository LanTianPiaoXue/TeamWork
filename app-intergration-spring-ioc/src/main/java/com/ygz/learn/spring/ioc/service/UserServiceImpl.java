package com.ygz.learn.spring.ioc.service;

import com.ygz.learn.spring.ioc.dao.UserDao;
import com.ygz.learn.spring.ioc.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by admin on 2017/8/14.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(UserEntity userEntity) {
        userDao.saveUser(userEntity);
        System.out.println("Service save userEntity------------");
    }

    public List<UserEntity> getUser(String id) {
        List<UserEntity> userEntities =  userDao.getUser(id);
        Optional.ofNullable(userEntities).ifPresent(System.out::println);
        System.out.println("Service get user------------");
        return userEntities;
    }
}
