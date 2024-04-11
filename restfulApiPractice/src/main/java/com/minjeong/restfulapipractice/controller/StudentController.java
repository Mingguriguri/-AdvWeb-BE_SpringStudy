package com.minjeong.restfulapipractice.controller;

import com.minjeong.restfulapipractice.dto.RequestBodyDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {

    @GetMapping
    public String sayHello()
    {
        return "Hello World";
    }

    @GetMapping("/id/{student_id}")
    public String getStudentId(@PathVariable int student_id){
        return "My Student Id is  "+student_id;
    }

    @GetMapping("/name/{name}")
    public String getName(@PathVariable String name){
        return "My Name is "+name;
    }

    @PostMapping("/student_info")
    public String getNameAndStdId(@RequestBody RequestBodyDTO requestBodyDTO){
        return "Hello !! My name is  " + requestBodyDTO.getName() +
                " and My Student Id is " + requestBodyDTO.getStd_id();

    }

}
