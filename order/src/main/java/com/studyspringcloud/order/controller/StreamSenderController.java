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

@RestController
@EnableBinding(StreamClient.class)
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
        streamClient.output().send(MessageBuilder.withPayload(person).build());
    }

    @StreamListener(value = "returnMsg")
    public void returnMsg(String msg) {
        System.out.println("reurn message:"+msg);
    }
}
