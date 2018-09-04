package com.yzhao.dubbo.samples.direct.client;

import com.yzhao.dubbo.samples.direct.api.DirectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DirectConsumer {

    public static void main(String... args) {

        System.setProperty("java.net.preferIPv4Stack", "true");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/direct-consumer.xml"});

        context.start();

        DirectService directService = (DirectService) context.getBean("directService");

        String hello1 = directService.sayHello("world1");
        System.out.println(hello1);

        int i = 10;

        while (i>0) {
            try {
                Thread.sleep(1000);
                String hello = directService.sayHello("world");
                System.out.println(hello);
                i--;
            }catch (Throwable t) {
                t.printStackTrace();
            }
        }

        String hello2 = directService.sayHello("world2");
        System.out.println(hello2);
    }
}
