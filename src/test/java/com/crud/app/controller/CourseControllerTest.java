package com.crud.app.controller;

import com.crud.app.model.Course;
import com.crud.app.repository.CoursesRepository;
import com.crud.app.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void testGetCourses() throws Exception {
//        Course course1 = new Course(1, "Course 1", 40, "http://example.com/course1", Optional.of("Notes 1"));
//        Course course2 = new Course(2, "Course 2", 50, "http://example.com/course2", Optional.empty());

        Course course1 = new Course.Builder()
                .id(1)
                .name("Course 1")
                .length(40)
                .url("http://example.com/course1")
                .notes(Optional.of("Notes 1"))
                .build();

        Course course2 = new Course.Builder()
                .id(2)
                .name("Course 2")
                .length(50)
                .url("http://example.com/course2")
                .notes(Optional.empty())
                .build();

        Mockito.when(courseService.getAllCourses()).thenReturn(Arrays.asList(course1, course2));

        mockMvc.perform(get("/courses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name':'Course 1','length':40,'url':'http://example.com/course1','notes':'Notes 1'},{'name':'Course 2','length':50,'url':'http://example.com/course2','notes':null}]"));
    }

    @Test
    public void testAddCourse() throws Exception {
//        Course newCourse = new Course(3, "Course 3", 60, "http://example.com/course3", Optional.of("Notes 3"));

        Course newCourse = new Course.Builder()
                .id(3)
                .name("Course 3")
                .length(60)
                .url("http://example.com/course3")
                .notes(Optional.of("Notes 3"))
                .build();

        Mockito.when(courseService.saveCourse(Mockito.any(Course.class))).thenReturn(newCourse);

        mockMvc.perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Course 3\",\"length\":60,\"url\":\"http://example.com/course3\",\"notes\":\"Notes 3\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id':3,'name':'Course 3','length':60,'url':'http://example.com/course3','notes':'Notes 3'}"));
    }
}