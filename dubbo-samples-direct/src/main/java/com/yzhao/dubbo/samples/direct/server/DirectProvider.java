package com.yzhao.dubbo.samples.direct.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DirectProvider {

    public static void main(String[] args) throws IOException{

        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/direct-provider.xml"});

        context.start();

        System.in.read();
    }

}
