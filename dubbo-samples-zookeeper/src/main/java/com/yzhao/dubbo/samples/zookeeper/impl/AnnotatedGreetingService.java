package com.yzhao.dubbo.samples.zookeeper.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yzhao.dubbo.samples.zookeeper.api.GreetingService;

@Service
public class AnnotatedGreetingService implements GreetingService {

    @Override
    public String sayHello(String name) {
        System.out.println("Greeting service received: " + name);
        return "hello, " + name;
    }
}
