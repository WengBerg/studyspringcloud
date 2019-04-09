package com.studyspringcloud.order.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


/**
 * 使用 stream 首先定义一个接口
 */
public interface StreamClient {

    String MSG = "myStreamMsg"; //发送消息的队列名称

    String RETURN_MSG = "returnMsg"; //消费消息成功返回消息的队列名称
    @Output(MSG)
    MessageChannel output();

    @Input(RETURN_MSG)
    SubscribableChannel input();
}
