package com.studyspringcloud.order.controller;

import com.studyspringcloud.order.entity.Person;
import com.studyspringcloud.order.msg.StreamClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
这里采用的 controoller 的方式来测试发送消息
 */
@RestController
@EnableBinding(StreamClient.class)  // 这里必须要绑定接口，否者就会启动报错，查找不到 streamClient
public class StreamSenderController {

    @Autowired
    private StreamClient streamClient;

     // 测试 stream 发送方法

/*    @GetMapping("sendMsg")
    public void send() {
        streamClient.output().send(MessageBuilder.withPayload(new Date().toString()).build());
    }

    @GetMapping("sendDate")
    public void send1() {
        streamClient.output().send(MessageBuilder.withPayload(new Date()).build());
    }*/
    @GetMapping("sendPerson")
    public void send2() {
        Person person = new Person();
        person.setName("Berg");
        person.setSex("man");
        streamClient.output().send(MessageBuilder.withPayload(person).build()); // 发送消息
    }

    @StreamListener(value = StreamClient.RETURN_MSG)
    public void returnMsg(String msg) {
        System.out.println("reurn message:"+msg);
    } // 消费消息后的返回
}
