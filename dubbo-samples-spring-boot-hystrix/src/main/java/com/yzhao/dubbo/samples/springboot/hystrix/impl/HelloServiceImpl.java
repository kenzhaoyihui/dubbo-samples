package com.yzhao.dubbo.samples.springboot.hystrix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yzhao.dubbo.samples.springboot.hystrix.api.HelloService;


@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {


    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })

    @Override
    public String sayHello(String name) {

        System.out.println("async provider received: " + name);
        return "annotation: hello, " + name;

        //throw new RuntimeException("Exception to show hystrix enabled...");
    }
}
