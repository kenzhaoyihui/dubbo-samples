package com.yzhao.dubbo.samples.validation.api;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public interface ValidationService {

    void save(ValidationParamter validationParamter);

    void update(ValidationParamter validationParamter);

    void delete(@Min(1) long id, @NotNull @Size(min = 2, max = 16) @Pattern(regexp = "^[a-zA-Z]+$") String opertaor);


    /**
     * annotation which has the same name with the method but has the first letter in capital
     * used for distinguish validation scenario, for example: @NotNull(groups = ValidationService.Save.class)
     * optional
     */
    @interface Save{
    }

    @interface Update{
    }
}
