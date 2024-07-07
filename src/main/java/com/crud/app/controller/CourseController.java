package com.crud.app.controller;

import com.crud.app.model.Course;
import com.crud.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> getCourses() {
        try {
            return courseService.getAllCourses()
                    .stream()
                    .sorted(Comparator.comparing(Course::getId))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error fetching courses", e);
        }
    }
}
