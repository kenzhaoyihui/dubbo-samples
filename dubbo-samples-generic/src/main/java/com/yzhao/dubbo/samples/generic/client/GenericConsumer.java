package com.yzhao.dubbo.samples.generic.client;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.yzhao.dubbo.samples.generic.api.IUserService;
import com.yzhao.dubbo.samples.generic.api.Params;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class GenericConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/generic-consumer.xml"});

        context.start();

        GenericService userService = (GenericService) context.getBean("userService");

//        IUserService userService1 = (IUserService) context.getBean("userService");

        String name  = (String) userService.$invoke("delete", new String[]{int.class.getName()}, new Object[]{1});
        System.out.println(name);

        String[] parameterType = new  String[]{"com.yzhao.dubbo.samples.generic.api.Params"};
        Map<String, Object> param = new HashMap<>();

        param.put("name", "love");
        param.put("class", "com.yzhao.dubbo.samples.generic.api.Params");
        param.put("query", "a=b" );
        Object user = userService.$invoke("get", parameterType, new Object[]{param});
        System.out.println("Sample one result: " + user);

        //Sample two
        user = userService.$invoke("get", null,  new Object[]{new Params("a=b")});
        System.out.println("Sample two result: " + user);

        //Sample three
        GenericService helloService = (GenericService) context.getBean("helloService");
        String hello = (String) helloService.$invoke("hello", new String[]{String.class.getName()}, new Object[]{"lj","yzhao"});
        String hello1 = (String) helloService.$invoke("hello1", new String[]{String.class.getName()}, new Object[]{"lj","yzhao"});

        System.out.println("Sample three result: " + hello);
        System.out.println("Welcome return: " + hello1);


        //Sample four
        GenericService hiService = (GenericService) context.getBean("hiService");
        String hi = (String) hiService.$invoke("hi", new String[]{String.class.getName()}, new Object[]{"haha", "xixi"});
        System.out.println("Sample four result: " + hi);


    }
}
