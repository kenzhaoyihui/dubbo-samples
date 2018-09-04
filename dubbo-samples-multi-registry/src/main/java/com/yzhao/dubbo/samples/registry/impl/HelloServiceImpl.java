package com.yzhao.dubbo.samples.registry.impl;

import com.yzhao.dubbo.samples.registry.api.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
