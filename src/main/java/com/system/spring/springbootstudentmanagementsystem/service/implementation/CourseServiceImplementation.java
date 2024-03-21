package com.system.spring.springbootstudentmanagementsystem.service.implementation;

import com.system.spring.springbootstudentmanagementsystem.entity.Course;
import com.system.spring.springbootstudentmanagementsystem.repository.CourseRepository;
import com.system.spring.springbootstudentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImplementation implements CourseService {


    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {

        Optional<Course> result = courseRepository.findById(id);

        Course course = null;

        if (result.isPresent()) {
            course = result.get();
        } else {
            // we didn't find the course
            throw new RuntimeException("Did not find course id - " + id);
        }
        return course;
    }


    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
}
