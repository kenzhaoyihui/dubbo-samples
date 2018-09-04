package com.yzhao.dubbo.samples.echo.client;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.yzhao.dubbo.samples.echo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EchoConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});

        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");

        String hello = demoService.sayHello("My love");
        System.out.println(hello);

        EchoService echoService = (EchoService) demoService;
        String status = (String) echoService.$echo("OK");

        System.out.println("Echo result: " + status);
    }
}
