package com.yzhao.dubbo.samples.async.server;

import com.yzhao.dubbo.samples.async.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AsyncProvider {

    public static void main(String[] args) throws IOException{
        new EmbeddedZookeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/async-provider.xml"});
        context.start();
        System.in.read();
    }
}
