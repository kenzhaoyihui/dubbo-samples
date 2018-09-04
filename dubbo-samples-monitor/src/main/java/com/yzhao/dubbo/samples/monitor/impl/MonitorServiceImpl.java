package com.yzhao.dubbo.samples.monitor.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.monitor.api.MonitorService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonitorServiceImpl implements MonitorService {

    @Override
    public String sayHello(String name) {

        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " +
        name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
