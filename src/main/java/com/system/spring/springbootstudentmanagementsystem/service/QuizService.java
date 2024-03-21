package com.system.spring.springbootstudentmanagementsystem.service;

import com.system.spring.springbootstudentmanagementsystem.entity.Quiz;
import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import com.system.spring.springbootstudentmanagementsystem.repository.QuizRepository;

import java.util.List;

public interface QuizService {

    List<Quiz> findAll();


    Quiz findById(int id);

    Quiz save(Quiz quiz);

    void deleteById(int id);

}
