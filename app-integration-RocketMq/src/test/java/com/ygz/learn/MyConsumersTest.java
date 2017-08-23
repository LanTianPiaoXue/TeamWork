package com.ygz.learn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygz.learn.consumers.MyConsumer;
import com.ygz.learn.model.User;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class MyConsumersTest {
    private final Logger logger = LoggerFactory.getLogger(MyConsumersTest.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        myConsumer = (MyConsumer) applicationContext.getBean("myConsumer");
    }
    private static MyConsumer myConsumer;
    @Test
    public void testConsumers(){
        User user = new User();
        user.setPwd("AAA");
        user.setId(111);
        user.setUserName("aaa");
        try {
            try {
                this.getMessage(user);
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public void getMessage(User user) throws RemotingException, InterruptedException, MQBrokerException, JsonProcessingException, MQClientException {
        myConsumer.init();
    }
}
