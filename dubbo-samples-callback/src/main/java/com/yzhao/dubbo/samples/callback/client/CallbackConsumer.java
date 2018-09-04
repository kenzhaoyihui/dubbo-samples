package com.yzhao.dubbo.samples.callback.client;

import com.yzhao.dubbo.samples.callback.api.CallbackListener;
import com.yzhao.dubbo.samples.callback.api.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CallbackConsumer {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/callback-consumer.xml"});

        context.start();

        CallbackService callbackService = (CallbackService) context.getBean("callbackService");

        callbackService.addListener("foo.bar", new CallbackListener() {
            @Override
            public void changeed(String msg) {
                System.out.println("Callback Function: " + msg);
            }
        });

        System.in.read();
    }
}
