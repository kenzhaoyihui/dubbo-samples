package com.yzhao.dubbo.samples.callback.server;

import com.yzhao.dubbo.samples.callback.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CallbackProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/callback-provider.xml"});

        context.start();

        System.in.read();
    }
}
