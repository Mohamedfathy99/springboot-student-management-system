package com.system.spring.springbootstudentmanagementsystem.service.implementation;

import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import com.system.spring.springbootstudentmanagementsystem.repository.StudentRepository;
import com.system.spring.springbootstudentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);

        Student student = null;

        if (result.isPresent()) {
            student = result.get();
        }
        else {
            // we didn't find the student
            throw new RuntimeException("Did not find student id - " + id);
        }

        return student;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
