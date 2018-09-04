package com.yzhao.dubbo.samples.generic.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.yzhao.dubbo.samples.generic.api.HelloService;
import com.yzhao.dubbo.samples.generic.api.HiService;

public class APIGenericConsumer {

    public static void main(String[] args) {

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("api-generic-consumer1");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        applicationConfig.setRegistry(registryConfig);

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(HiService.class);
        referenceConfig.setApplication(applicationConfig);
        HiService hiService = (HiService) referenceConfig.get();
        System.out.println("HiService result: " + hiService.hi("hihihihihihihihhi"));


        ReferenceConfig<GenericService> referenceConfig1 = new ReferenceConfig<>();
        referenceConfig1.setInterface(HelloService.class);
        referenceConfig1.setApplication(applicationConfig);
        HelloService helloService = (HelloService) referenceConfig1.get();
        System.out.println("HellloService result: " + helloService.hello("hellohello"));

    }
}
