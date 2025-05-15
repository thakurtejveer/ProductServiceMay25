package com.scaler.productservicemay25.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/greet/{fname}/{lname}")
    public  String sayHello(@PathVariable("lname") String a, @PathVariable("fname") String b ) {
        return "Hello World1 "+ a +" "+ b;
    }

    @GetMapping("/greet2")
    public  String sayBye(@RequestParam("x") int x) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<x; i++) {
            sb.append("Hello World2!\n");
        }
        return sb.toString();
    }
}
