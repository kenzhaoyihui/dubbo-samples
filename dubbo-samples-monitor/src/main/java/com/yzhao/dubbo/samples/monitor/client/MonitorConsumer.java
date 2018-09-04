package com.yzhao.dubbo.samples.monitor.client;

import com.yzhao.dubbo.samples.monitor.api.MonitorService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MonitorConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/monitor-consumer.xml"}
        );

        context.start();

        MonitorService monitorService = (MonitorService) context.getBean("monitorService");

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(monitorService.sayHello("yzhao"));
            }catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
