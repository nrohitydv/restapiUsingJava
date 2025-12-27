package com.codewithrohit.learnigrestapis.service;

import com.codewithrohit.learnigrestapis.dto.AddNewStudentDto;
import com.codewithrohit.learnigrestapis.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto>  findAllStudents();

    StudentDto getStudentByID(long id);

    StudentDto createNewStudent(AddNewStudentDto addNewStudentDto);

    void deleteById(long id);

     StudentDto updateStudent(long id, AddNewStudentDto addNewStudentDto);

     StudentDto updatesParticialStudent(long id, Map<String, Object> update);
}
