package com.studyspringcloud.product.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 使用 stream 首先定义一个接口
 */
public interface StreamClient {

    String MSG = "myStreamMsg";

    String RETURN_MSG = "returnMsg";
    @Input(MSG)
    SubscribableChannel input();

    @Output(RETURN_MSG)
    MessageChannel output();

}
