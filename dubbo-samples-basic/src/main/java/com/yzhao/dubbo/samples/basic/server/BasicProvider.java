package com.yzhao.dubbo.samples.basic.server;

import com.yzhao.dubbo.samples.basic.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class BasicProvider {

    public static void main(String[] args) throws IOException{
        new EmbeddedZookeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/basic-provider.xml"});
        context.start();

        System.in.read();
    }
}
