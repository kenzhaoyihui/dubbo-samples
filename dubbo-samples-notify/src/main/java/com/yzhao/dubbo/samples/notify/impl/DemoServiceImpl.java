package com.yzhao.dubbo.samples.notify.impl;

import com.yzhao.dubbo.samples.notify.api.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(int id) {
        return "Hello-- " + id;
    }
}
