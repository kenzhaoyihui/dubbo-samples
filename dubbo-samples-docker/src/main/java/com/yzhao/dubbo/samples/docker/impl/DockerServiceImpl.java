package com.yzhao.dubbo.samples.docker.impl;

import com.yzhao.dubbo.samples.docker.api.DockerService;

public class DockerServiceImpl implements DockerService {

    @Override
    public String hello(String name) {
        return name;
    }
}
