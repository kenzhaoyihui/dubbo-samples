package com.yzhao.dubbo.samples.context.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.context.api.ContextService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/context-consumer.xml"});

        context.start();

        ContextService contextService = (ContextService) context.getBean("contextService");

        String hello = contextService.sayHello("world");

        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
        String application = RpcContext.getContext().getUrl().getParameter("application");
        String serverIP = RpcContext.getContext().getRemoteHost();

        System.out.println(hello);

        System.out.println("IsConsumerSide=" + isConsumerSide + ", Application=" + application + ", ServerIP=" + serverIP );
    }
}
