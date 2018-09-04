package com.yzhao.dubbo.samples.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yzhao.dubbo.samples.api.GreetingService;

@Service
public class AnnotatedGreetingService implements GreetingService {

    @Override
    public String sayHello(String name) {
        System.out.println("Greeting service received: " + name);
        return "Hello, " + name;
    }
}
