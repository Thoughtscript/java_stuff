package com.baeldung.springbootdispatcherservlet.domain;

public class Example {
    private String name;

    public Example(String name) {
        this.name = name;
    }

    public Example() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
