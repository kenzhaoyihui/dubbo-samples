package com.yzhao.dubbo.samples.merge.impl;

import com.yzhao.dubbo.samples.merge.api.MergeService;

import java.util.ArrayList;
import java.util.List;

public class MergeServiceImpl3 implements MergeService {

    @Override
    public List<String> mergeResult() {
        //return null;
        List<String> list = new ArrayList<>();
        list.add("group-3.1");
        list.add("group-3.2");
        return list;
    }
}
