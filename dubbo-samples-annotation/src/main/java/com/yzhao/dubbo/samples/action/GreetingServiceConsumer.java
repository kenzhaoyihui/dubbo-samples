package com.yzhao.dubbo.samples.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yzhao.dubbo.samples.api.GreetingService;
import org.springframework.stereotype.Component;

@Component("annotationConsumer")
public class GreetingServiceConsumer {

    @Reference
    private GreetingService greetingService;

    public String doSayHello(String name) {
        return greetingService.sayHello(name);
    }
}
