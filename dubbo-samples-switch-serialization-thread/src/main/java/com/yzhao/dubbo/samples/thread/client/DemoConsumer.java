package com.yzhao.dubbo.samples.thread.client;

import com.yzhao.dubbo.samples.thread.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/switch-serialization-thread-consumer.xml"}
        );

        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");

        System.out.println(demoService.sayHello("yzhao"));
    }
}
