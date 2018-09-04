package com.yzhao.dubbo.samples.generic.impl;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;

public class GenericServiceImpl implements GenericService {
    @Override
    public Object $invoke(String s, String[] strings, Object[] objects) throws GenericException {
        if ("hi".equals(s)) {
            return "hi, " + objects[0];
        } else if ("hello".equals(s)) {
            return "hello, " + objects[0];
        }
        return "welcome!";
    }
}
