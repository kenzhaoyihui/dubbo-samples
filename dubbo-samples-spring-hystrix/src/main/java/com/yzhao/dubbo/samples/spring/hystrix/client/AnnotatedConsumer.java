package com.yzhao.dubbo.samples.spring.hystrix.client;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.yzhao.dubbo.samples.spring.hystrix.action.AnnotatedAction;
import org.springframework.context.annotation.*;

import java.io.IOException;

public class AnnotatedConsumer {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConsumerConfiguration.class
        );

        context.start();

        AnnotatedAction annotatedAction = (AnnotatedAction) context.getBean("annotatedAction");

        String hello = annotatedAction.doSayHello("yzhao");


        //System.out.println("Result: " + hello);
        System.err.println("result: " + hello);
        System.in.read();
    }


    @Configuration
    @ComponentScan(value = "com.yzhao.dubbo.samples.spring.hystrix.action")
    @EnableDubbo
    @EnableAspectJAutoProxy
    @PropertySource("classpath:/spring/spring-hystrix-consumer.properties")
    public static class ConsumerConfiguration {
        @Bean
        public HystrixCommandAspect hystrixCommandAspect() {
            return new HystrixCommandAspect();
        }
    }
}
