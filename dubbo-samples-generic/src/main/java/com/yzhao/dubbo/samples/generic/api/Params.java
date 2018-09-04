package com.yzhao.dubbo.samples.generic.api;

import java.io.Serializable;

public class Params implements Serializable {
    private static final long serialVersionUID = 1L;

    private String query;

    public Params(String query) {
        super();
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
