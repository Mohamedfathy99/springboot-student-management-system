package com.system.spring.springbootstudentmanagementsystem.controller;

import com.system.spring.springbootstudentmanagementsystem.entity.Quiz;
import com.system.spring.springbootstudentmanagementsystem.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/list")
    public String findAllQuizzes(Model model){
        List<Quiz> quizzes = quizService.findAll();
        model.addAttribute("quizzes", quizzes);
        return "list-quizzes";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Quiz quiz = new Quiz();
        model.addAttribute("quiz", quiz);
        return "create-quiz";
    }

    @GetMapping("/updateQuizForm")
    public String updateQuizForm(@RequestParam("quizId") int id, Model model){
        Quiz quiz = quizService.findById(id);
        model.addAttribute("quiz", quiz);
        return "create-quiz";
    }

    @PostMapping("/save")
    public String saveQuiz(@ModelAttribute ("quiz") Quiz quiz){
        quizService.save(quiz);
        return "redirect:/quizzes/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("quizId") int id){
        quizService.deleteById(id);
        return "redirect:/quizzes/list";
    }
}