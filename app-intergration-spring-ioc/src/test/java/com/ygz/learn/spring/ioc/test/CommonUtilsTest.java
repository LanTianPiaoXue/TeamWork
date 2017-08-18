package com.ygz.learn.spring.ioc.test;

import com.ygz.learn.spring.ioc.utils.CommonUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by admin on 2017/8/14.
 */
public class CommonUtilsTest {
    @Test
    public void test1() throws IOException {
        String resourceName = "META-INF/test.xml";
        InputStream is = ClassLoader.getSystemResourceAsStream(resourceName);
        Properties props = new Properties();
            try {
                if(resourceName.endsWith(".xml")) {
                    props.loadFromXML(is);
                } else {
                    props.load(is);
                }
            } finally {
                is.close();
            }
        System.out.println(props);
    }
     @Test
    public void testSpringIoc5() throws IOException {
        String resourceName2 = "META-INF/spring.schemas";
        InputStream is2 = CommonUtils.getInputStream(resourceName2);
        Properties props = new Properties();
            try {
                if(resourceName2.endsWith(".xml")) {
                    props.loadFromXML(is2);
                } else {
                    props.load(is2);
                }
            } finally {
                is2.close();
            }
        System.out.println(props);
    }

    @Test
    public void testSpringIoc6() throws IOException {
        String resourceName2 = "spring";
//        String key = "http\\://www.learn.ygz.com/schema/user.xsd";
        String key = "aaa";
        String value =  CommonUtils.getString(resourceName2,key);
        System.out.println("value:"+value);
    }

}
