package com.spring.tutorial.ecommercebackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String Test(){
        return "TEST GOOD";
    }
}
