package com.studyspringcloud.order.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


/**
 * 使用 stream 首先定义一个接口
 */
public interface StreamClient {
    @Output("myStreamMsg")
    MessageChannel output();

    @Input("returnMsg")
    SubscribableChannel input();
}
