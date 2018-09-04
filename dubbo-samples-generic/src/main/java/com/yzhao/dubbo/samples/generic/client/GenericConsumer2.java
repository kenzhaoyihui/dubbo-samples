package com.yzhao.dubbo.samples.generic.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

public class GenericConsumer2 {

    public static void main(String[] args) {

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("api-generic-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        applicationConfig.setRegistry(registryConfig);

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();

        referenceConfig.setInterface(com.yzhao.dubbo.samples.generic.api.IUserService.class);

        referenceConfig.setGeneric(true);

        referenceConfig.setApplication(applicationConfig);

        GenericService genericService = referenceConfig.get();

        String name = (String) genericService.$invoke("delete", new String[]{int.class.getName()}, new Object[]{1});
        System.out.println(name);

        Object user = genericService.$invoke("get", null, null);
        System.out.println("Sample result: " + user);
    }
}
