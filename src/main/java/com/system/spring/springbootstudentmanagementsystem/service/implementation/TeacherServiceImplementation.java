package com.system.spring.springbootstudentmanagementsystem.service.implementation;

import com.system.spring.springbootstudentmanagementsystem.entity.Student;
import com.system.spring.springbootstudentmanagementsystem.entity.Teacher;
import com.system.spring.springbootstudentmanagementsystem.repository.TeacherRepository;
import com.system.spring.springbootstudentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImplementation implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImplementation(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        Optional<Teacher> result = teacherRepository.findById(id);

        Teacher teacher = null;

        if (result.isPresent()) {
            teacher = result.get();
        }
        else {
            // we didn't find the teacher
            throw new RuntimeException("Did not find teacher id - " + id);
        }

        return teacher;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}
