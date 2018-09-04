package com.yzhao.dubbo.samples.context.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.context.api.ContextService;

public class ContextServiceImpl implements ContextService {

    @Override
    public String sayHello(String name) {
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        String clientIP = RpcContext.getContext().getRemoteHost();
        String application = RpcContext.getContext().getUrl().getParameter("application");

        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress() +
                ", ClientIP=" + clientIP + ", Application=" + application + ", isProviderSide=" + isProviderSide;
    }
}
