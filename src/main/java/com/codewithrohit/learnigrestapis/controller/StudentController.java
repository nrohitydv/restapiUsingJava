package com.codewithrohit.learnigrestapis.controller;


import com.codewithrohit.learnigrestapis.dto.AddNewStudentDto;
import com.codewithrohit.learnigrestapis.dto.StudentDto;
import com.codewithrohit.learnigrestapis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
@PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable long id, @RequestBody AddNewStudentDto addNewStudentDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addNewStudentDto));
}
@PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatesParticialStudent(@PathVariable long id, @RequestBody Map<String,Object> update){
        return ResponseEntity.ok(studentService.updatesParticialStudent(id,update));
}



}
