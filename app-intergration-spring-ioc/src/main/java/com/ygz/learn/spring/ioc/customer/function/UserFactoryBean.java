package com.ygz.learn.spring.ioc.customer.function;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by admin on 2017/8/17.
 */
public class UserFactoryBean implements FactoryBean<User>{
    private String userInfo;

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public User getObject() throws Exception {
        String[] userArray = this.userInfo .split(",");
        User user = new User();
        user.setName(userArray[0]);
        user.setId(userArray[1]);
        user.setPwd(userArray[2]);
        user.setAge(Integer.parseInt(userArray[3]));
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
