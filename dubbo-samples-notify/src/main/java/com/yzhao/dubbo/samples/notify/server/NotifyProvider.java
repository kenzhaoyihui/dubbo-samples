package com.yzhao.dubbo.samples.notify.server;

import com.yzhao.dubbo.samples.notify.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class NotifyProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/notify-provider.xml"}
        );

        context.start();

        System.in.read();
    }
}
