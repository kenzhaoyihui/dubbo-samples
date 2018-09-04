package com.yzhao.dubbo.samples.merge.client;

import com.yzhao.dubbo.samples.merge.api.MergeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

public class MergeConsumer2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/merge-consumer2.xml"});
        context.start();

        MergeService mergeService = (MergeService) context.getBean("mergeService");

        List<String> result = mergeService.mergeResult();

        Iterator<String> iterator = result.iterator();
        while (true) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
