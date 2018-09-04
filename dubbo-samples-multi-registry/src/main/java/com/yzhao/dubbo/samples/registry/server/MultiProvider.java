package com.yzhao.dubbo.samples.registry.server;

import com.yzhao.dubbo.samples.registry.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MultiProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();
        new EmbeddedZookeeper(2182, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/multi-registry-provider.xml"});

        context.start();

        System.in.read();
    }
}
