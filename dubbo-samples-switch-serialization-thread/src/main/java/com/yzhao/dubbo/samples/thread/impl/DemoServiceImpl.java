package com.yzhao.dubbo.samples.thread.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.thread.api.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(
                new Date()) + "] Hello: " + name + ", request from the consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello: " + name + ", response from the provider: " + RpcContext.getContext().getLocalAddress();
    }
}
