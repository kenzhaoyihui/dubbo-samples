package com.yzhao.dubbo.samples.springboot.hystrix.client;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yzhao.dubbo.samples.springboot.hystrix.api.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableHystrix
public class ConsumerApplication {

    @Reference(version = "1.0.0")
    private HelloService helloService;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
        ConsumerApplication application = context.getBean(ConsumerApplication.class);

        String result = application.doSayHello("yzhao");
        System.out.println("Result: " + result);
    }


    @HystrixCommand(fallbackMethod = "reliable")
    public String doSayHello(String name) {
        return helloService.sayHello(name);
    }

    public String reliable(String name) {
        return "hystrix fallback value...";
    }
}
