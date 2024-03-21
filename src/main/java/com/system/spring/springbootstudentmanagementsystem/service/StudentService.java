package com.system.spring.springbootstudentmanagementsystem.service;

import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void deleteById(int id);
}
