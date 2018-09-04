package com.yzhao.dubbo.samples.zookeeper.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.yzhao.dubbo.samples.zookeeper.action.GreetingServiceConsumer;
import com.yzhao.dubbo.samples.zookeeper.api.GreetingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class ConsumerBootstrap {

    public static void main(String[] args) throws IOException{
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConsumerConfiguration.class
        );

        context.start();


        GreetingServiceConsumer greetingServiceConsumer = context.getBean(GreetingServiceConsumer.class);
        String hello = greetingServiceConsumer.doSayHello("zookeeper");
        System.out.println("result: " + hello);
        System.in.read();

    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.yzhao.dubbo.samples.zookeeper.action")
    @PropertySource("classpath:/spring/zookeeper-consumer.properties")
    @ComponentScan("com.yzhao.dubbo.samples.zookeeper.action")
    static class ConsumerConfiguration {

    }
}
