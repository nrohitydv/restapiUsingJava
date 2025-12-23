package com.codewithrohit.learnigrestapis.controller;


import com.codewithrohit.learnigrestapis.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
@GetMapping("/student")
public StudentDto  getStudent(){
    return new StudentDto("1","Rupesh","rupeshs@gmail.com");
}


}
