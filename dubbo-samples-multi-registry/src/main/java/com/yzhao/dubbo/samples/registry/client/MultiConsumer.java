package com.yzhao.dubbo.samples.registry.client;

import com.yzhao.dubbo.samples.registry.api.DemoService;
import com.yzhao.dubbo.samples.registry.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultiConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/multi-registry-consumer.xml"});

        context.start();

        HelloService helloService1 = (HelloService) context.getBean("helloService1");
        HelloService helloService2 = (HelloService) context.getBean("helloService2");

        DemoService demoService2 = (DemoService) context.getBean("demoService2");

        String name1 = helloService1.sayHello("yzhao1");
        System.out.println(name1);

        String name2 = helloService2.sayHello("yzhao2");
        System.out.println(name2);



        name2 = demoService2.get("yzhao2");
        System.out.println(name2);

        try{
            DemoService demoService1 = (DemoService) context.getBean("demoService1");
            name1 = demoService1.get("yzhao1");
            System.out.println(name1);
        }catch (Exception e){
            System.out.println("----------------------------------Cannot get demoService1 bean from the registry-------------------------------");
        }
    }
}
