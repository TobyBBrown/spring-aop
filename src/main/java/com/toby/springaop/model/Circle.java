package com.toby.springaop.model;

import com.toby.springaop.aspect.Loggable;

public class Circle {

    private String name;

    @Loggable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
