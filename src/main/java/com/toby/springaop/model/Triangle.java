package com.toby.springaop.model;

public class Triangle {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting Triangle name");
        this.name = name;
    }

    private String name;
}
