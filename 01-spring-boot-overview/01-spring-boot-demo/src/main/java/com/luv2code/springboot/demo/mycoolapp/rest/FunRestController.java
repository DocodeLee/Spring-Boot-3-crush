package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //expose "/workout" that return "Hello World"
    @GetMapping("/workout")
    public String showWorkOut(){
        return "Work Hard like all of the guys";
    }

    //expose "/workout" that return "Hello World"
    @GetMapping("/badboys")
    public String badBoys(){
        return "Are you bad boys?";
    }

}
