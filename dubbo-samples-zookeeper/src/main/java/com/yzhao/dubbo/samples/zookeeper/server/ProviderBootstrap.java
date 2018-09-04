package com.yzhao.dubbo.samples.zookeeper.server;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class ProviderBootstrap {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.yzhao.dubbo.samples.zookeeper.impl")
    @PropertySource("classpath:/spring/zookeeper-provider.properties")
    static class ProviderConfiguration {

    }
}
