package com.thoughtscript.springunit.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    Logger log = LoggerFactory.getLogger(ExampleService.class);

    public String helloText() {
        return "Hello You!";
    }
}