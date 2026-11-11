package com.walletemu.hello;

import com.walletemu.hello.dto.HelloResponse;
import
org.springframework.web.bind.annotation.GetMapping;

import
org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HelloController{

    @GetMapping("/hello")
    public HelloResponse hello() {

     return new HelloResponse(UUID.randomUUID(), "Olá, mundo!");





    }
}
