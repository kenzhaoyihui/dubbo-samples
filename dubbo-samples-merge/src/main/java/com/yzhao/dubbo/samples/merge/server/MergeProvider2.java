package com.yzhao.dubbo.samples.merge.server;

import com.yzhao.dubbo.samples.merge.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MergeProvider2 {
    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/merge-provider2.xml"});
        context.start();

        System.in.read();
    }
}
