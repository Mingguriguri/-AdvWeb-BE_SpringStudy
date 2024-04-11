package com.favicon.HelloWorld.controller;

import com.favicon.HelloWorld.dto.RequestBodyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String sayHello()
    {
        return "Hello World";
    }

    @GetMapping("/helloGetMapping")
    public String sayHelloWithPath(){
        return "Hello World! Path: " +
                System.getProperty("user.dir");
    }

    @GetMapping("/{id}")
    public String sayHelloWithPathVariables (@PathVariable(required=false) int id){
        return "Hello World! ID: " + id;
    }


    @GetMapping("/helloRequestParam")
    public String sayHelloWithRequestParam(@RequestBody(required=false) int id ){
        return "Hello World! ID: " + id;
    }

    @GetMapping("/helloRequestBody")
    public String sayHelloWithRequestBody(@RequestBody RequestBodyDTO requestBodyDTO){
        return "Hello World! ID: " + requestBodyDTO.getId() +
                " Message " + requestBodyDTO.getMessage();

    }


}
