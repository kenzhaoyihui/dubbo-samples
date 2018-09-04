package com.yzhao.dubbo.samples.spring.hystrix.server;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.yzhao.dubbo.samples.spring.hystrix.support.EmbeddedZookeeper;
import org.springframework.context.annotation.*;

import java.io.IOException;

public class AnnotatedProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ProviderConfiguration.class
        );

        context.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.yzhao.dubbo.samples.spring.hystrix.impl")
    @PropertySource("classpath:/spring/sprint-hystrix-provider.properties")
    @EnableAspectJAutoProxy
    static public class ProviderConfiguration {

        @Bean
        public HystrixCommandAspect hystrixCommandAspect() {
            return new HystrixCommandAspect();
        }
    }
}
