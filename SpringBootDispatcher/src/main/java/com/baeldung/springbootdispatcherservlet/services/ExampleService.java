package com.baeldung.springbootdispatcherservlet.services;

import com.baeldung.springbootdispatcherservlet.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public Example fetchExample() {
        return new Example("EXAMPLE_NAME");
    }
}
