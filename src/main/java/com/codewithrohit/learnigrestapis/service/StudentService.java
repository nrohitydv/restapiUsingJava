package com.codewithrohit.learnigrestapis.service;

import com.codewithrohit.learnigrestapis.dto.AddNewStudentDto;
import com.codewithrohit.learnigrestapis.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto>  findAllStudents();

    StudentDto getStudentByID(long id);

    StudentDto createNewStudent(AddNewStudentDto addNewStudentDto);

    void deleteById(long id);
}
