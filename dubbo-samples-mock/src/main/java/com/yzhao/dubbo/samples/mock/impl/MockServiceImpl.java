package com.yzhao.dubbo.samples.mock.impl;

import com.yzhao.dubbo.samples.mock.api.MockService;

public class MockServiceImpl implements MockService {

    @Override
    public String sayHello(String name) {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello:" + name;
    }
}
