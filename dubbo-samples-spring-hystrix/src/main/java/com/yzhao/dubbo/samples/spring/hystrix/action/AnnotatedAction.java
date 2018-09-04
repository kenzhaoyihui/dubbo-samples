package com.yzhao.dubbo.samples.spring.hystrix.action;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yzhao.dubbo.samples.spring.hystrix.api.AnnotatedService;
import org.springframework.stereotype.Component;

@Component("annotatedAction")
public class AnnotatedAction {

    @Reference
    private AnnotatedService annotatedService;

    @HystrixCommand(fallbackMethod = "reliable")
    public String doSayHello(String name) {
        return annotatedService.sayHello(name);
    }

    public String reliable(String name) {
        return "hystrix fallback value";
    }
}
