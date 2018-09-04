package com.yzhao.dubbo.samples.cache.server;

import com.yzhao.dubbo.samples.cache.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CacheProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/cache-provider.xml"});
        context.start();

        System.in.read();
    }
}
