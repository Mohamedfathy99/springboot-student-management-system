package com.system.spring.springbootstudentmanagementsystem.service;

import com.system.spring.springbootstudentmanagementsystem.entity.Course;
import com.system.spring.springbootstudentmanagementsystem.entity.Student;

import java.util.List;

public interface CourseService {


    List<Course> findAll();

    Course findById(int id);

    Course save(Course course);

    void deleteById(int id);
}
