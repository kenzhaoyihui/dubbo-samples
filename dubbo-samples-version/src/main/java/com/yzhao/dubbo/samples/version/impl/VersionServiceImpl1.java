package com.yzhao.dubbo.samples.version.impl;

import com.yzhao.dubbo.samples.version.api.VersionService;

public class VersionServiceImpl1 implements VersionService {

    @Override
    public String sayHello(String name) {
        System.out.println("Receive the request with version1: " + name);
        return "Version1: " + name;
    }
}
