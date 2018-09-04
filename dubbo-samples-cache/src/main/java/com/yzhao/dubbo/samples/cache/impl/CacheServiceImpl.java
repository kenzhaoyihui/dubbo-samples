package com.yzhao.dubbo.samples.cache.impl;

import com.yzhao.dubbo.samples.cache.api.CacheService;

import java.util.concurrent.atomic.AtomicInteger;

public class CacheServiceImpl implements CacheService {

    private final AtomicInteger i = new AtomicInteger();

    @Override
    public String findCache(String id) {
        return "request: " + id + ", response: " + i.getAndIncrement();
    }
}
