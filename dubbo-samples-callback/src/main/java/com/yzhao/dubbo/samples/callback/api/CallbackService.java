package com.yzhao.dubbo.samples.callback.api;

public interface CallbackService {

    void addListener(String key, CallbackListener listener);
}
