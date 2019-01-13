package com.studyspringcloud.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("test")
    public String testCreate() {
        return "testProduct";
    }

    @GetMapping("msg")
    public String msg() {
        return "feign";
    }
}
