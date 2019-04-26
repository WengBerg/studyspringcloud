package com.studyspringcloud.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*
@EnableZuulServer、@EnableZuulProxy 为开启Zuul的两个注解
具体不同可看：http://www.itmuch.com/spring-cloud/zuul/zuul-filter-in-spring-cloud/
 */

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
