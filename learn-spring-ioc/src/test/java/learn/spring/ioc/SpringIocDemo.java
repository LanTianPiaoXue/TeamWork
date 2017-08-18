package learn.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by admin on 2017/7/29.
 */
public class SpringIocDemo {
    @Test
    public void testApplicationContext() {
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.isPrototype("");
        // load xml bean  XmlBeanFactory
        ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        BeanDefinitionRegistry beanDefinitionRegistry = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);

        BeanDefinition
//        DefaultResourceLoader
//        Document
//        DOMUtils
//        BeanDefinition
//        ClassUtils.forName()
//        BeanUtils
//        Enhancer
        Boolean.FALSE.equals(true);
    }
}
