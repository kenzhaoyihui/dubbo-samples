package com.yzhao.dubbo.samples.server;

import com.yzhao.dubbo.samples.api.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        //return null;
        return "Hi, " + name;
    }
}
