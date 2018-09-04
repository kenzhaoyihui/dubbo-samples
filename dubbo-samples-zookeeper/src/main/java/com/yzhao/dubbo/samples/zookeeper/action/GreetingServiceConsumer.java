package com.yzhao.dubbo.samples.zookeeper.action;


import com.alibaba.dubbo.config.annotation.Reference;
import com.yzhao.dubbo.samples.zookeeper.api.GreetingService;
import org.springframework.stereotype.Component;

@Component("annotatedConsumer")
public class GreetingServiceConsumer {

    @Reference
    private GreetingService greetingService;

    public String doSayHello(String name) {
        return greetingService.sayHello(name);
    }
}
