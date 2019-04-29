package com.custom.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message(){
        return "Hello world - what a beautiful world!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
