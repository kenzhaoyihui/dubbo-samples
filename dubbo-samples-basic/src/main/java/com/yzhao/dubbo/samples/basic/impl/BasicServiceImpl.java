package com.yzhao.dubbo.samples.basic.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.basic.api.BasicService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicServiceImpl implements BasicService {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date())
         + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());

        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
