package com.codewithrohit.learnigrestapis.controller;


import com.codewithrohit.learnigrestapis.dto.AddNewStudentDto;
import com.codewithrohit.learnigrestapis.dto.StudentDto;
import com.codewithrohit.learnigrestapis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping
public ResponseEntity<List<StudentDto>> getStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
}


    @GetMapping("/{id}")
public ResponseEntity<StudentDto>  getStudentById(@PathVariable long id){
    return ResponseEntity.ok(studentService.getStudentByID(id));
}
@PostMapping
    public ResponseEntity<StudentDto> addNewStudent(@RequestBody AddNewStudentDto  addNewStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addNewStudentDto));
}
@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable long id){
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
}



}
