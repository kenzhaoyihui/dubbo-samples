package com.yzhao.dubbo.samples.generic.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.yzhao.dubbo.samples.generic.api.HelloService;
import com.yzhao.dubbo.samples.generic.api.HiService;
import com.yzhao.dubbo.samples.generic.impl.GenericServiceImpl;
import com.yzhao.dubbo.samples.generic.support.EmbeddedZookeeper;

import java.io.IOException;

public class APIGenericProvider {

    public static void main(String[] args) throws IOException {

        new EmbeddedZookeeper(2181, false).start();

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("api-generic-provider");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        applicationConfig.setRegistry(registryConfig);

        GenericService genericService = new GenericServiceImpl();

        // Export HelloService
        ServiceConfig<GenericService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
//        serviceConfig.setInterface(com.yzhao.dubbo.samples.generic.api.HelloService.class);
        serviceConfig.setInterface(HelloService.class);
        serviceConfig.setRef(genericService);
        serviceConfig.export();

        //Export HiService
        ServiceConfig<GenericService> serviceConfig1 = new ServiceConfig<>();
        serviceConfig1.setApplication(applicationConfig);
        serviceConfig1.setRef(genericService);
//        serviceConfig1.setInterface(com.yzhao.dubbo.samples.generic.api.HiService.class);
        serviceConfig1.setInterface(HiService.class);
        serviceConfig1.export();

        System.in.read();



    }
}
