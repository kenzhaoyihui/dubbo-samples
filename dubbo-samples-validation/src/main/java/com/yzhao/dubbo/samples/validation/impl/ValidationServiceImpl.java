package com.yzhao.dubbo.samples.validation.impl;

import com.yzhao.dubbo.samples.validation.api.ValidationParamter;
import com.yzhao.dubbo.samples.validation.api.ValidationService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public void save(ValidationParamter validationParamter) {
        System.out.println("Save OK");
    }

    @Override
    public void delete(@Min(1) long id, @NotNull @Size(min = 2, max = 16) @Pattern(regexp = "^[a-zA-Z]+$") String opertaor) {
        System.out.println("Delete OK");
    }

    @Override
    public void update(ValidationParamter validationParamter) {

    }
}
