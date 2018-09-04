package com.yzhao.dubbo.samples.notify.impl;

import com.yzhao.dubbo.samples.notify.api.Notify;

import java.util.HashMap;
import java.util.Map;

public class NotifyImpl implements Notify {

    public Map<Integer, String> ret = new HashMap<>();

    @Override
    public void onreturn(String name, int id) {
        ret.put(id, name);
        System.out.println("onReturn: " + name);
    }

    @Override
    public void onthrow(Throwable throwable, String name, int id) {
        System.out.println("onthrow: " + name);
    }
}
