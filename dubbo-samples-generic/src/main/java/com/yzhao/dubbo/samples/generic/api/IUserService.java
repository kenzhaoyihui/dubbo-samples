package com.yzhao.dubbo.samples.generic.api;

public interface IUserService {

    User get(Params params);

    String delete(int id);

}
