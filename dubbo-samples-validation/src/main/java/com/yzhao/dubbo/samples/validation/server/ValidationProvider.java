package com.yzhao.dubbo.samples.validation.server;

import com.yzhao.dubbo.samples.validation.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ValidationProvider  {

    public static void main(String[] args) throws IOException{
        new EmbeddedZookeeper(2181, false).start();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/validation-provider.xml"}
        );
        context.start();

        System.in.read();
    }
}
