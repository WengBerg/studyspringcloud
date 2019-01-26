package com.studyspringcloud.product.message;

import com.studyspringcloud.product.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {
    private final Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

/*    @StreamListener(value = "myStreamMsg")
    public void receive(String msg) {
        logger.info("receive:{}",  msg);
    }

    @StreamListener(value = "myStreamMsg")
    public void receive1(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        logger.info("receive:{}",  dateFormat.format(date));
    }*/

    @StreamListener(value = "myStreamMsg")
    @SendTo(value = "returnMsg")
    public String  receive2(Person p) {
        logger.info("name:{}",p.getName());
        logger.info("sex:{}",p.getSex());
        return "received message";
    }
}
