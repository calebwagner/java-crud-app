package com.crud.app.service;

import com.crud.app.model.Course;
import com.crud.app.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CoursesRepository coursesRepository;

    @Autowired
    public CourseService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return coursesRepository.save(course);
    }
}
