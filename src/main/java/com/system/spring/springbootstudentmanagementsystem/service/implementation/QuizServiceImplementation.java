package com.system.spring.springbootstudentmanagementsystem.service.implementation;

import com.system.spring.springbootstudentmanagementsystem.entity.Quiz;
import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import com.system.spring.springbootstudentmanagementsystem.repository.QuizRepository;
import com.system.spring.springbootstudentmanagementsystem.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImplementation implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImplementation(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz findById(int id) {
        Optional<Quiz> result = quizRepository.findById(id);

        Quiz quiz = null;

        if (result.isPresent()) {
            quiz = result.get();
        }
        else {
            // we didn't find the quiz
            throw new RuntimeException("Did not find quiz id - " + id);
        }

        return quiz;

    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public void deleteById(int id) {
        quizRepository.deleteById(id);
    }
}
