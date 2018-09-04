package com.yzhao.dubbo.samples.mock.api;

import java.util.concurrent.TimeUnit;

public class MockServiceMock implements MockService {

    @Override
    public String sayHello(String name) {
        System.out.println("Mock Impl Called...");
        return "Local: " + name;
    }
}
