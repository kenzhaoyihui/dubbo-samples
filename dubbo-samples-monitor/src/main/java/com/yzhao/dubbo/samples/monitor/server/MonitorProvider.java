package com.yzhao.dubbo.samples.monitor.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MonitorProvider {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/monitor-provider.xml"});

        context.start();

        System.in.read();
    }




}
