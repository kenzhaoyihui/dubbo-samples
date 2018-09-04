package com.yzhao.dubbo.samples.group.server;

import com.yzhao.dubbo.samples.group.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class GroupProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/group-provider.xml"});
        context.start();

        System.in.read();
    }
}
