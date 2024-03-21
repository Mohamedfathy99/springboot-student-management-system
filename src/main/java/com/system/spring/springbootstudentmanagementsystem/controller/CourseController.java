package com.system.spring.springbootstudentmanagementsystem.controller;

import com.system.spring.springbootstudentmanagementsystem.entity.Course;
import com.system.spring.springbootstudentmanagementsystem.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public String findAllCourses(Model model){
        List<Course> courses = courseService.findAll();
        model.addAttribute("courses", courses);
        return "list-courses";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "create-course";
    }

    @GetMapping("/updateCourseForm")
    public String updateCourseForm(@RequestParam("courseId") int id, Model model){
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        return "create-course";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.save(course);
        return "redirect:/courses/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("courseId") int id){
        courseService.deleteById(id);
        return "redirect:/courses/list";
    }
}