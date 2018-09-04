package com.yzhao.dubbo.samples.callback.impl;

import com.yzhao.dubbo.samples.callback.api.CallbackListener;
import com.yzhao.dubbo.samples.callback.api.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CallbackServiceImpl implements CallbackService {

    private final Map<String, CallbackListener> listenerMap = new ConcurrentHashMap<>();

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try{
                        for (Map.Entry<String, CallbackListener> entry: listenerMap.entrySet()) {
                            try {
                                entry.getValue().changeed(getChanged(entry.getKey()));
                            }catch (Throwable throwable) {
                                listenerMap.remove(entry.getKey());
                            }
                        }
                        Thread.sleep(5000);
                    }catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        });

        t.setDaemon(true);
        t.start();
    }


    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    @Override
    public void addListener(String key, CallbackListener listener) {
        listenerMap.put(key, listener);
        listener.changeed(getChanged(key));
    }
}
