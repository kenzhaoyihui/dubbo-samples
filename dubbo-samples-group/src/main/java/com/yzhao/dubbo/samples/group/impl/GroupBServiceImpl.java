package com.yzhao.dubbo.samples.group.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.group.api.GroupService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GroupBServiceImpl implements GroupService {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name +
                ", request from consumer: " + RpcContext.getContext().getRemoteAddress() + "in groupB");
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress() + " in groupB";
    }
}
