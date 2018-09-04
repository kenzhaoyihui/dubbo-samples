package com.yzhao.dubbo.samples.context.server;

import com.yzhao.dubbo.samples.context.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ContextProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/context-provider.xml"});

        context.start();

        System.in.read();
    }
}
