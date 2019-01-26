package com.studyspringcloud.product.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyReceiver {
    private final Logger logger = LoggerFactory.getLogger(MyReceiver.class);

    // @RabbitListener(queues = "myQueue")  这里需要在 rabbitmq 中手动添加 myQueue 队列，不然就会报错
    // @RabbitListener(queuesToDeclare = @Queue("myQueue"))  // 自动声明 myQueue 队列
    @RabbitListener(bindings = @QueueBinding( // 自动创建，Exchange和Queue绑定，具体绑定还应该添加 key 参数。消息分组
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    )
    )
    public void receive(String msg) {
        logger.info("receive:{}",msg);
    }

    /**
     * 服务1，Exchange 绑定测试
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("server1"),
            key = "server1",
            exchange = @Exchange("server")
    ))
    public void recevice1(String msg) {
        logger.info("receive server1:{}",msg);
    }

    /**
     * 服务2，Exchange 绑定测试
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("server2"),
            key = "server2",
            exchange = @Exchange("server")
    ))
    public void recevice2(String msg) {
        logger.info("receive server2:{}",msg);
    }
}
