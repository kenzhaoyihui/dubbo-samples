package com.yzhao.dubbo.samples.mock.client;

import com.yzhao.dubbo.samples.mock.api.MockService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MockConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/mock-consumer.xml"});

        context.start();

        MockService mockService = (MockService) context.getBean("mockService");

        String name = mockService.sayHello("yzhao");
        System.out.println(name);
    }
}
