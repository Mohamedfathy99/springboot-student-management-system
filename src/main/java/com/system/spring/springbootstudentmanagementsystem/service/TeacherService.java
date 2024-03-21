package com.system.spring.springbootstudentmanagementsystem.service;

import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import com.system.spring.springbootstudentmanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAll();

    Teacher findById(int id);

    Teacher save(Teacher teacher);

    void deleteById(int id);
}
