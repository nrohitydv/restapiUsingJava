package com.codewithrohit.learnigrestapis.controller;


import com.codewithrohit.learnigrestapis.dto.StudentDto;
import com.codewithrohit.learnigrestapis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping("/students")
public List<StudentDto> getStudents(){
        return studentService.findAllStudents();
}


    @GetMapping("/students/{id}")
public StudentDto  getStudentById(@PathVariable long id){
    return studentService.getStudentByID(id);
}



}
