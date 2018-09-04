package com.yzhao.dubbo.samples.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.yzhao.dubbo.samples.support.EmbeddedZooKeeper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

public class ProviderBootstrap {

    public static void main(String[] args) throws Exception {
        new EmbeddedZooKeeper(2181, false).start();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.yzhao.dubbo.samples.impl")
    @PropertySource("classpath:/spring/dubbo-provider.properties")
    static class ProviderConfiguration {
    }
}
