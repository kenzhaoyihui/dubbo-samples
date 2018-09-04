package com.yzhao.dubbo.samples.version.server;

import com.yzhao.dubbo.samples.version.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class VersionProvider2 {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2182, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/version-provider2.xml"}
        );

        context.start();

        System.in.read();
    }
}
