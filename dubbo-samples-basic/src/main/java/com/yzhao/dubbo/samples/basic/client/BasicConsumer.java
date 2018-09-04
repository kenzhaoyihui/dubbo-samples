package com.yzhao.dubbo.samples.basic.client;

import com.yzhao.dubbo.samples.basic.api.BasicService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/basic-consumer.xml"});
        context.start();

        BasicService basicService = (BasicService) context.getBean("basicService");

        while (true) {
            try {
                Thread.sleep(1000);
                String hello = basicService.sayHello("world");
                System.out.println(hello);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
