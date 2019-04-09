package com.studyspringcloud.order.message;

import com.studyspringcloud.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySender extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue",new Date().toString());
    }

    /*
    测试服务1.发送
     */
    @Test
    public void send1() {
        amqpTemplate.convertAndSend("server","server1",new Date().toString());
    }

    /*
    测试服务2.发送
     */
    @Test
    public void send2() {
        amqpTemplate.convertAndSend("server","server2",new Date().toString());
    }
}
