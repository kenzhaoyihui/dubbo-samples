package com.yzhao.dubbo.samples.stub.server;

import com.yzhao.dubbo.samples.stub.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class StudProvider {

    public static void main(String[] args) throws IOException{
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/stub-provider.xml"}
        );

        context.start();
        System.in.read();
    }
}
