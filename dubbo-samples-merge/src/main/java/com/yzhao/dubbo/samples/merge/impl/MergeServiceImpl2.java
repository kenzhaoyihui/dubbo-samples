package com.yzhao.dubbo.samples.merge.impl;

import com.yzhao.dubbo.samples.merge.api.MergeService;

import java.util.ArrayList;
import java.util.List;

public class MergeServiceImpl2 implements MergeService {

    @Override
    public List<String> mergeResult() {
        //return null;
        List<String> list = new ArrayList<>();
        list.add("group-2.1");
        list.add("group-2.2");
        return list;
    }
}
