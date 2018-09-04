package com.yzhao.dubbo.samples.http.client;

import com.yzhao.dubbo.samples.http.api.HttpService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/http-consumer.xml"});

        context.start();

        HttpService httpService = (HttpService) context.getBean("httpService");
        HttpService httpService1 = (HttpService) context.getBean("httpService1");
        String hello = httpService.sayHello("yzhao");
        String hello1 = httpService1.sayHello("lj");

        System.out.println(hello);
        System.out.println(hello1);
    }
}
