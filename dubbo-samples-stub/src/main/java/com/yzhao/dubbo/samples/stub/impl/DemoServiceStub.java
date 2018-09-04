package com.yzhao.dubbo.samples.stub.impl;

import com.yzhao.dubbo.samples.stub.api.DemoService;

public class DemoServiceStub implements DemoService {

    private DemoService demoService;

    public DemoServiceStub(DemoService demoService) {
        this.demoService = demoService;
    }


    @Override
    public String sayHello(String name) {
        System.out.println("stub-sayHello");

        try {
            return demoService.sayHello(name);
        }catch (Exception e) {
            return null;
        }
    }
}
