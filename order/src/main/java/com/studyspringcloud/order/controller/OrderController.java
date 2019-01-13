package com.studyspringcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * RestTemplate的第一种用法，写死调用链接
     * @return
     */
    @GetMapping("testOrder")
    public String testOrder() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9000/product/test", String.class);
        return forObject;
    }

    /**
     * 利用LoadBalancerClient获取应用的url
     * @return
     */
    @GetMapping("testOrder2")
    public String testOrder2() {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance prodtct = loadBalancerClient.choose("product");
        String url = String.format("http://%s:%s/product/test", prodtct.getHost(), prodtct.getPort());
        String s = restTemplate.getForObject(url, String.class);
        return s;
    }

    /**
     * 利用@LoadBalanced注解，restTemplate中直接使用应用名字
     * @return
     */
    @GetMapping("testOrder3")
    public String testOrder3() {
        String s = restTemplate.getForObject("http://product/product/test", String.class);
        return s;
    }
}
