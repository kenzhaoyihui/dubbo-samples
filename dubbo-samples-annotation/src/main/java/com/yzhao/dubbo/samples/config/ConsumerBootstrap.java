package com.yzhao.dubbo.samples.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.yzhao.dubbo.samples.action.GreetingServiceConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class ConsumerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        GreetingServiceConsumer greetingServiceConsumer = context.getBean(GreetingServiceConsumer.class);
        String hello = greetingServiceConsumer.doSayHello("configuration");
        System.out.println("result: " + hello);
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.yzhao.dubbo.samples.action")
    @PropertySource("classpath:/spring/dubbo-consumer.properties")
    @ComponentScan(value = {"com.yzhao.dubbo.samples.action"})
    static class ConsumerConfiguration {

    }
}
