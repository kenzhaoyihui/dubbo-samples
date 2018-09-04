package com.yzhao.dubbo.samples.thread.server;

import com.yzhao.dubbo.samples.thread.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DemoProvider {

    public static void main(String[] args) throws IOException{
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/switch-serialization-thread-provider.xml"}
        );

        context.start();

        System.in.read();
    }
}
