package com.system.spring.springbootstudentmanagementsystem.controller;

import com.system.spring.springbootstudentmanagementsystem.entity.Teacher;
import com.system.spring.springbootstudentmanagementsystem.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/list")
    public String findAllTeachers(Model model){

        // get the teachers from db
        List<Teacher> teachers = teacherService.findAll();

        // add to the spring model
        model.addAttribute("teachers", teachers);
        return "list-teachers";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){

        // create model attribute to bind form data
        Teacher teacher = new Teacher();
        // our thymeleaf template will access this data for binding from data
        model.addAttribute("teacher", teacher);

        return "create-teacher";
    }

    @GetMapping("/updateTeacherForm")
    public String updateTeacherForm(@RequestParam("teacherId") int id, Model model){

        // get the teacher from the service
        Teacher teacher = teacherService.findById(id);

        // set teacher in the model to pre-populate the form
        model.addAttribute("teacher", teacher);

        // send over to our form
        return "create-teacher";
    }

    @PostMapping("/save")
    public String saveTeacher(@ModelAttribute ("teacher") Teacher teacher){

        // save the teacher
        teacherService.save(teacher);

        // use a redirect to prevent duplicate submissions
        return "redirect:/teachers/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("teacherId") int id){

        // delete the teacher
        teacherService.deleteById(id);

        // redirect to the /teachers/list
        return "redirect:/teachers/list";
    }

}