package com.yzhao.dubbo.samples.async.impl;

import com.yzhao.dubbo.samples.async.api.AsyncService;

public class AsyncServiceImpl implements AsyncService {

    @Override
    public String sayHello(String name) {
        System.out.println("Async provider received: " + name);
        return "Hello, " + name;
    }

    @Override
    public String goodBye(String name) {
        return "GoodBye, " + name;
    }
}
