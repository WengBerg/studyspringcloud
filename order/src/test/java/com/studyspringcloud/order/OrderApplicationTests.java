package com.studyspringcloud.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // 如果这里不加 classes = OrderApplication.class 会导致 StreamClient 无法注入
public class OrderApplicationTests {

    @Test
    public void contextLoads() {
    }

}

