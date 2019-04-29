package com.custom.customapp;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CustomappApplication {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message(){
        return "Hello world - what a cruel world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomappApplication.class, args);
    }

}
