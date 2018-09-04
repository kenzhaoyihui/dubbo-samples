package com.yzhao.dubbo.samples.springboot.hystrix.server;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.yzhao.dubbo.samples.springboot.hystrix.support.EmbeddedZookeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"com.yzhao.dubbo.samples.springboot.hystrix.impl"})
@EnableHystrix
public class ProviderApplication {

    public static void main(String[] args) {
        new EmbeddedZookeeper(2181, false).start();

        SpringApplication.run(ProviderApplication.class, args);
    }
}
