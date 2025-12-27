package com.codewithrohit.learnigrestapis.service.imp;

import com.codewithrohit.learnigrestapis.dto.AddNewStudentDto;
import com.codewithrohit.learnigrestapis.dto.StudentDto;
import com.codewithrohit.learnigrestapis.entity.Student;
import com.codewithrohit.learnigrestapis.repository.StudentRepository;
import com.codewithrohit.learnigrestapis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentByID(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found" + id));
        return modelMapper.map(student, StudentDto.class);

    }

    @Override
    public StudentDto createNewStudent(AddNewStudentDto addNewStudentDto) {
        Student newStudent = modelMapper.map(addNewStudentDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteById(long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("student not found" + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, AddNewStudentDto addNewStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found" + id));
        modelMapper.map(addNewStudentDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatesParticialStudent(long id, Map<String, Object> update) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found" + id));
        update.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("field not supported" + id);
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }

}
