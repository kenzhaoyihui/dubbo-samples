package com.yzhao.dubbo.samples.attachment.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.attachment.api.AttachmentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AttachmentConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/attachment-consumer.xml"});
        context.start();

        AttachmentService attachmentService = (AttachmentService) context.getBean("attachmentService"); // get remote service proxy

        RpcContext.getContext().setAttachment("index", "1");
        String hello = attachmentService.sayHello("attachment-world");
        System.out.println(hello);  //get result

        hello = attachmentService.sayHello("attachment-world-again");
        System.out.println(hello); // get result
    }
}
