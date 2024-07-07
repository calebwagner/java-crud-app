package com.crud.app.service;


import com.crud.app.model.Course;
import com.crud.app.repository.CoursesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @MockBean
    private CoursesRepository coursesRepository;

    @Test
    public void testGetAllCourses() {
        Course course1 = new Course(1, "Course 1", 40, "http://example.com/course1", Optional.of("Notes 1"));
        Course course2 = new Course(2, "Course 2", 50, "http://example.com/course2", Optional.empty());

        Mockito.when(coursesRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        List<Course> courses = courseService.getAllCourses();

        assertThat(courses).hasSize(2).contains(course1, course2);
    }
}