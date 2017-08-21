package com.ygz.learn.spring.ioc.test;

import com.ygz.learn.spring.ioc.customer.function.User;
import com.ygz.learn.spring.ioc.customer.function.User_V1;
import com.ygz.learn.spring.ioc.customer.function.UserFactoryBean;
import com.ygz.learn.spring.ioc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by admin on 2017/8/14.
 */
public class SpringIocTest {
    @Test
    public void testSpringIoc(){
        String beanXml = "beanXml.xml";
        Resource classPathResource = new ClassPathResource(beanXml);
        //        BeanDefinitionRegistry
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUser("3");
    }
    @Test
    public void testSpringIoc2(){
        String beanXml = "beanXml.xml";
        Resource classPathResource = new ClassPathResource(beanXml);
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        UserService userService = (UserService) xmlBeanFactory.getBean("userService");
//        UserEntity user = (UserEntity) xmlBeanFactory.getBean("user");
//        System.out.println("user:"+user);
        userService.getUser("3");

    }
    @Test
    public void testSpringIocFactoryBean(){
        String beanXml = "factoryBean.xml";
        Resource classPathResource = new ClassPathResource(beanXml);
        DefaultListableBeanFactory xmlBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(xmlBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
        User userBean = (User) xmlBeanFactory.getBean("userBean");
        UserFactoryBean userFactoryBean = (UserFactoryBean) xmlBeanFactory.getBean("&userBean");
        System.out.println("userFactoryBean:"+userFactoryBean);
        System.out.println("user:"+userBean);


    }
    @Test
    public void testSpringIoc3(){
//        MethodReplacer
        ClassPathResource classPathResource = new ClassPathResource("UserTag.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(classPathResource);
       User user = (User) beanFactory.getBean("001");
        System.out.println(user);
    }
    @Test
    public void testSpringIoc4(){
        String beanXml = "UserTag.xml";
        Resource classPathResource = new ClassPathResource(beanXml);
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        User_V1 user = (User_V1) xmlBeanFactory.getBean("001");
        System.out.println(user);

    }
     @Test
    public void testSpringIocApplicationContext(){
        String beanXml = "factoryBean.xml";
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{beanXml});
         User userBean = (User) applicationContext.getBean("userBean");
         System.out.println(userBean);
//         StandardBeanExpressionResolver
     }

}
