package com.thoughtscript.springunit.controllers;

import com.thoughtscript.springunit.services.ExampleService;
import com.thoughtscript.springunit.transfer.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class ExampleController {

    Logger log = LoggerFactory.getLogger(ExampleController.class);

    @Autowired
    private ExampleService testService;

    @ResponseBody
    @GetMapping("/fetch")
    public Response test() {
        Response r = new Response();
        r.setText(testService.helloText());
        return r;
    }
}