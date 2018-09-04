package com.yzhao.dubbo.samples.generic.server;

import com.yzhao.dubbo.samples.generic.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class GenericProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/generic-provider.xml"});

        context.start();

        System.in.read();
    }
}
