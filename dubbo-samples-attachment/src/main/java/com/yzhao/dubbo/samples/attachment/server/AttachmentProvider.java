package com.yzhao.dubbo.samples.attachment.server;

import com.yzhao.dubbo.samples.attachment.support.EmbeddedZookeeper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AttachmentProvider {

    public static void main(String[] args) throws IOException {
        new EmbeddedZookeeper(2181, false).start();
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/attachment-provider.xml"});
        context.start();

        System.in.read(); // press any key to exit
    }
}
