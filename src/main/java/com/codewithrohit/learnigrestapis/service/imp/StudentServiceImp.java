package com.codewithrohit.learnigrestapis.service.imp;

import com.codewithrohit.learnigrestapis.dto.StudentDto;
import com.codewithrohit.learnigrestapis.entity.Student;
import com.codewithrohit.learnigrestapis.repository.StudentRepository;
import com.codewithrohit.learnigrestapis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student>  students = studentRepository.findAll();

        return students.stream().map(student -> modelMapper.map(student,StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentByID(long id) {
        Student student= studentRepository.findById(id).orElseThrow(()->new  IllegalArgumentException("student not found" + id));
        return modelMapper.map(student,StudentDto.class);

    }
}
