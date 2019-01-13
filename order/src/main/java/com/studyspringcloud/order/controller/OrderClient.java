package com.studyspringcloud.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product")
public interface OrderClient {

    @GetMapping("/product/msg")
    public String msg();

}
