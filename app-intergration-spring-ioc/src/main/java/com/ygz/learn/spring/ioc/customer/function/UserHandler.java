package com.ygz.learn.spring.ioc.customer.function;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by admin on 2017/8/15.
 */
public class UserHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
