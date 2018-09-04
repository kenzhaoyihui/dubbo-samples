package com.yzhao.dubbo.samples.async.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.yzhao.dubbo.samples.async.api.AsyncService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class AsyncConsumer  {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/async-consumer.xml"});
        context.start();

        final AsyncService service = (AsyncService) context.getBean("asyncService");

        Future<String> future = RpcContext.getContext().asyncCall(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return service.sayHello("Async class request");
            }
        });

        System.out.println("Async class result: " + future.get());


        RpcContext.getContext().asyncCall(new Runnable() {
            @Override
            public void run() {
                service.sayHello("first call request1...");
                service.sayHello("second call request2...");
            }
        });

//        service.goodBye("dubbo-sample-async goodbye...");
//        Future<String> future1 = RpcContext.getContext().getFuture();
//        String result = future1.get();
//        System.out.println(result);

        Future<String> future1 = RpcContext.getContext().asyncCall(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return service.goodBye("dubbo-samples-async goodbye again...");
            }
        });

        System.out.println("Async goodbye result: " + future1.get());

        System.in.read();
    }
}
