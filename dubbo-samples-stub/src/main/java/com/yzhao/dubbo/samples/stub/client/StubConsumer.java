package com.yzhao.dubbo.samples.stub.client;

import com.yzhao.dubbo.samples.stub.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StubConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/stub-consumer.xml"}
        );

        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");

        demoService.sayHello("abcd");
    }
}
