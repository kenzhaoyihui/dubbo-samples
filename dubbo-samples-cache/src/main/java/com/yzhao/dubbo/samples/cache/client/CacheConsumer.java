package com.yzhao.dubbo.samples.cache.client;

import com.yzhao.dubbo.samples.cache.api.CacheService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/cache-consumer.xml"});

        context.start();

        CacheService cacheService = (CacheService) context.getBean("cacheService");

        String fix = null;
        for (int i=0;i<5;i++) {
            String result = cacheService.findCache("0");
            if (fix == null || fix.equals(result)) {
                System.out.println("OK: " + result);
            }else {
                System.out.println("ERROR: " + result);
            }

            fix = result;
            Thread.sleep(500);
        }

        // default cache.size is 1000 for LRU, should have cache expired if invoke more than 1001 times
        for (int n=0;n<1001;n++) {
            String pre = null;
            for (int i=0;i<10;i++) {
                String result = cacheService.findCache(String.valueOf(n));
                if (pre != null && !pre.equals(result)) {
                    System.out.println("ERROR: " + result);
                }

                pre = result;
            }
        }

        // verify if the first cache item is expired in LRU cache
        String result = cacheService.findCache("0");
        if (fix != null && !fix.equals(result)) {
            System.out.println("--OK: " + result);
        } else {
            System.out.println("ERROR: " + result);
        }
    }
}
