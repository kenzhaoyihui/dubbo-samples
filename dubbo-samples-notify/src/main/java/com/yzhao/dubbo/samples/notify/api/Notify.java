package com.yzhao.dubbo.samples.notify.api;

public interface Notify {

    void onreturn(String name, int id);

    void onthrow(Throwable throwable, String name, int id);
}
