package com.ygz.learn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygz.learn.consumers.MyConsumer;
import com.ygz.learn.model.User;
import com.ygz.learn.producers.MyProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class MyProducersTest {
    private final Logger logger = LoggerFactory.getLogger(MyProducersTest.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        myProducer = (MyProducer) applicationContext.getBean("myProducer");
        myConsumer = (MyConsumer) applicationContext.getBean("myConsumer");

    }
    private static MyConsumer myConsumer;
    private static MyProducer myProducer;
    @Test
    public void testProducers(){
        User user = new User();
        user.setPwd("AAA");
        user.setId(111);
        user.setUserName("aaa");
        try {
            this.sendMessage(user);
            this.myConsumer.init();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(User user) throws RemotingException, InterruptedException, MQBrokerException, JsonProcessingException {
            Message msg = new Message("MyTopic", "MyTag", (objectMapper.writeValueAsString(user)).getBytes());
            SendResult sendResult = null;
            try {
                sendResult = myProducer.getDefaultMQProducer().send(msg);
            } catch (MQClientException e) {
                logger.error(e.getMessage() + String.valueOf(sendResult));
            }
            // 当消息发送失败时如何处理
            if (sendResult == null || sendResult.getSendStatus() != SendStatus.SEND_OK) {
                // TODO
                logger.error("send error----"+sendResult.getMsgId());
            }
    }
}
