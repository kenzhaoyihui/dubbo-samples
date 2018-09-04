package com.yzhao.dubbo.samples.mock.server;

import com.yzhao.dubbo.samples.mock.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MockProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/mock-provider.xml"});

        context.start();

        System.in.read();


    }
}
