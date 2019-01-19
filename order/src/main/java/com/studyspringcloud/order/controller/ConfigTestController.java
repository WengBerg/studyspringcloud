package com.studyspringcloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${person.name}")
    private String name;

    @GetMapping("configTest")
    public String configTest() {
        return name;
    }
}
