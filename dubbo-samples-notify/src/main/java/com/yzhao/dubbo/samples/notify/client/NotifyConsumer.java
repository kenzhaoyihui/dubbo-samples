package com.yzhao.dubbo.samples.notify.client;

import com.yzhao.dubbo.samples.notify.api.DemoService;
import com.yzhao.dubbo.samples.notify.api.Notify;
import com.yzhao.dubbo.samples.notify.impl.NotifyImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NotifyConsumer {

    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/notify-consumer.xml"}
        );

        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        NotifyImpl notify = (NotifyImpl) context.getBean("notifyCallback");
        int id = 1;
        String result = demoService.sayHello(id);

        for(int i=0; i<10; i++) {
            if (!notify.ret.containsKey(i)) {
                Thread.sleep(200);
            }else {
                break;
            }
        }

        System.out.println(notify.ret.get(id));
    }
}
