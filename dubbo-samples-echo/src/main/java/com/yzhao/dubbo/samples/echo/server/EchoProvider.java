package com.yzhao.dubbo.samples.echo.server;

import com.yzhao.dubbo.samples.echo.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class EchoProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-provider.xml"});

        context.start();

        System.in.read();
    }
}
