package com.yzhao.dubbo.samples.version.impl;

import com.yzhao.dubbo.samples.version.api.VersionService;

public class VersionServiceImpl2 implements VersionService {

    @Override
    public String sayHello(String name) {
        System.out.println("Receive the request with version2: " + name);
        return "Version2: " + name;
    }
}
