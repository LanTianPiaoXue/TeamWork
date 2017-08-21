package com.ygz.learn.spring.ioc.customer.function;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

//        String id = "";
//        String name = "";
//        String pwd = "";
//        int age = 0;
//        NodeList childNodes = element.getChildNodes();
//        for(int i = 0; i < childNodes.getLength(); ++i) {
//            Node node = childNodes.item(i);
//            if(node instanceof Element) {
//                Element ele = (Element)node;
//                String tagName = ele.getTagName();
//                if (org.apache.commons.lang3.StringUtils.equals(tagName,"MyTag:id")){
//                    id = ele.getTextContent();
//                    continue;
//                }
//                 if (org.apache.commons.lang3.StringUtils.equals(tagName,"MyTag:name")){
//                     name = ele.getTextContent();
//                     continue;
//                }
//                 if (org.apache.commons.lang3.StringUtils.equals(tagName,"MyTag:pwd")){
//                     pwd = ele.getTextContent();
//                     continue;
//                }
//                 if (org.apache.commons.lang3.StringUtils.equals(tagName,"MyTag:age")){
//                     age = Integer.parseInt(ele.getTextContent());
//                     continue;
//                }
//                 if (org.apache.commons.lang3.StringUtils.equals(tagName,"MyTag:personInfo")){
//                     String pId = element.getAttribute("id");
//                     String pName = element.getAttribute("name");
//                     continue;
//                }
//
//            }
//        }
//        Element a = (Element)element.getElementsByTagName("").item(1);
//        Element a = (Element)element.getChildNodes().item(1);
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
//        if (Objects.nonNull(personInfo)){
//            builder.addPropertyValue("personInfo",personInfo);
//        }
    }

}
