package com.yzhao.dubbo.samples.merge.client;

import com.yzhao.dubbo.samples.merge.api.MergeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

public class MergeConsumer1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/merge-consumer.xml"});
        context.start();

        MergeService mergeService = (MergeService) context.getBean("mergeService");

        List<String> result = mergeService.mergeResult();

        Iterator<String> iterator = result.iterator();
        while (true) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

//        for (int i=0; i < Integer.MAX_VALUE; i++) {
//            try {
//                List<String> result = mergeService.mergeResult();
//                System.out.println("(" + i + ")" + result);
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
