package com.yzhao.dubbo.samples.generic.impl;

import com.yzhao.dubbo.samples.generic.api.IUserService;
import com.yzhao.dubbo.samples.generic.api.Params;
import com.yzhao.dubbo.samples.generic.api.User;

public class UserServiceImpl implements IUserService {

    @Override
    public User get(Params params) {
        return new User(1, "yzhao");
    }

    @Override
    public String delete(int id) {
        return "dubbo";
    }
}
