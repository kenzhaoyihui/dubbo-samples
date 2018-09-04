package com.yzhao.dubbo.samples.http.impl;

import com.yzhao.dubbo.samples.http.api.HttpService;

public class HttpServiceImpl2 implements HttpService {

    @Override
    public String sayHello(String name) {
        System.out.println("I'm using dubbo protocl");
        return "Hello " + name;
    }
}
