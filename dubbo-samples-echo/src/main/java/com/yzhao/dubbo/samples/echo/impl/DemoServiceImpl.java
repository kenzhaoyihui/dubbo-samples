package com.yzhao.dubbo.samples.echo.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.echo.api.DemoService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());

        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
