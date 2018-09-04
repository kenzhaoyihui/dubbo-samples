package com.yzhao.dubbo.samples.validation.api;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class ValidationParamter implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull //disallow null
    @Size(min = 2, max = 20)
    private String name;

    @NotNull(groups = ValidationService.Save.class)
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

    @NotNull
    @Min(18)
    @Max(60)
    private int age;

    @Past
    private Date loginDate;

    @Future
    private Date expiryDate;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
