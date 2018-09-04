package com.yzhao.dubbo.samples.attachment.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.attachment.api.AttachmentService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttachmentServiceImpl implements AttachmentService {

    @Override
    public String sayHello(String name) {
        String index = RpcContext.getContext().getAttachment("index");
        System.out.println("receive attachment index: " + index);

        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());

        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
