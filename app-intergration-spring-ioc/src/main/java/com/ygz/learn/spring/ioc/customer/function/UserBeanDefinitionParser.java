package com.ygz.learn.spring.ioc.customer.function;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import java.util.Objects;

/**
 * Created by admin on 2017/8/15.
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
   //element class
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
       String id = element.getAttribute("id");
       String name = element.getAttribute("name");
       String pwd = element.getAttribute("pwd");
       String age = element.getAttribute("age");
        PersonInfo personInfo = (PersonInfo)element.getAttributeNode("personInfo");
        if (StringUtils.hasText(id)){
            builder.addPropertyValue("id",id);
        }
        if (StringUtils.hasText(name)){
            builder.addPropertyValue("name",name);
        }
        if (StringUtils.hasText(pwd)){
            builder.addPropertyValue("pwd",pwd);
        }
        if (StringUtils.hasText(age)){
            builder.addPropertyValue("age",Integer.parseInt(age));
        }
        if (Objects.nonNull(personInfo)){
            builder.addPropertyValue("personInfo",personInfo);
        }
    }

}
