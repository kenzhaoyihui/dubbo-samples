package com.yzhao.dubbo.samples.group.client;

import com.yzhao.dubbo.samples.group.api.GroupService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GroupConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/group-consumer.xml"});

        context.start();

        GroupService groupServiceA = (GroupService) context.getBean("groupServiceA");

        GroupService groupServiceB = (GroupService) context.getBean("groupServiceB");

        GroupService groupServiceC = (GroupService) context.getBean("groupServiceC");

//        System.out.println(groupServiceA.sayHello("world"));
//
//        System.out.println(groupServiceB.sayHello("world"));

        while (true) {
            try {
                Thread.sleep(1000);
                String resultGroupA = groupServiceA.sayHello("world"); // call remote method
                System.out.println(resultGroupA); // get result

                String resultGroupB = groupServiceB.sayHello("world");
                System.out.println(resultGroupB); // get result

                String resultC = groupServiceC.sayHello("world");
                System.out.println(resultC);

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        }

    }
}
