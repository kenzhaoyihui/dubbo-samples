package com.yzhao.dubbo.samples.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.yzhao.dubbo.samples.api.GreetingService;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException{
        ServiceConfig<GreetingService> serviceServiceConfig = new ServiceConfig<>();
        serviceServiceConfig.setApplication(new ApplicationConfig("First-dubbo-provider"));
        serviceServiceConfig.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234"));
        serviceServiceConfig.setInterface(GreetingService.class);
        serviceServiceConfig.setRef(new GreetingServiceImpl());
        serviceServiceConfig.export();

        System.out.println("First-dubbo-provider is running");
        System.in.read();
    }
}
