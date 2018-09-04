package com.yzhao.dubbo.samples.registry.impl;

import com.yzhao.dubbo.samples.registry.api.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String get(String name) {
        return "get: " + name;
    }
}
