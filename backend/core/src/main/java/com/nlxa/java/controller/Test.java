package com.nlxa.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Test {

    @GetMapping(value = "/get/hello-world")
    public String getHelloWorld(){
        return "Hello world!";
    }
}
