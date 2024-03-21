package com.system.spring.springbootstudentmanagementsystem.controller;

import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import com.system.spring.springbootstudentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

/*
*
* Handle method for list students and return view and model
*
*/

    @GetMapping("/list")
    public String findAllStudent(Model model){

        // get the employees from db
        List<Student> students = studentService.findAll();

        // add to the spring model
        model.addAttribute("students", students);
        return "list-students";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){

        // create model attribute to bind form data
        Student student = new Student();
        // our thymeleaf template will access this data for binding from data
        model.addAttribute("student", student);

        return "create-student";
    }

    @GetMapping("/updateStudentForm")
    public String updateStudentForm(@RequestParam("studentId") int id, Model model){

        // get the student from the service
        Student student = studentService.findById(id);

        // set employee in the model to pre-populate the form
        model.addAttribute("student", student);

        // send over to our form
        return "create-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute ("student") Student student){

        // save the employee
        studentService.save(student);

        // use a redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int id){

        // delete the student
        studentService.deleteById(id);

        // redirect to the /students/list
        return "redirect:/students/list";
    }

}
