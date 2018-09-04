package com.yzhao.dubbo.samples.version.client;

import com.yzhao.dubbo.samples.version.api.VersionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VersionConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/version-consumer.xml"}
        );
        context.start();

        VersionService versionService1 = (VersionService) context.getBean("versionService1");
        VersionService versionService2 = (VersionService) context.getBean("versionService2");

//        VersionService versionService = (VersionService) context.getBean("versionService");

        String hello1 = versionService1.sayHello("zookeeper1");
        String hello2 = versionService2.sayHello("zookeeper2");

        System.out.println(hello1);
        System.out.println(hello2);
    }
}
