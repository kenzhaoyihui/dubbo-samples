package com.yzhao.dubbo.samples.http.server;

import com.yzhao.dubbo.samples.http.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class HttpProvider {

    public static void main(String[] args) throws IOException {

        new EmbeddedZookeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/http-provider.xml"});

        context.start();

        System.in.read();
    }
}
