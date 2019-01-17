package com.studyspringcloud.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product")
public interface OrderClient {

    // 此处应该是一个除域名和端口外完整的请求路径
    @GetMapping("/product/msg")
    public String msg();

}
