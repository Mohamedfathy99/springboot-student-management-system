package com.system.spring.springbootstudentmanagementsystem.repository;

import com.system.spring.springbootstudentmanagementsystem.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
