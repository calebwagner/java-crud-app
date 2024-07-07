package com.crud.app.repository;
import com.crud.app.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CoursesRepositoryTest {

    @Autowired
    private CoursesRepository coursesRepository;

    @Test
    public void testSaveAndFindById() {
        Course course = new Course("Course 1", 40, "http://example.com/course1", Optional.of("Notes 1"));
        Course savedCourse = coursesRepository.save(course);

        Optional<Course> foundCourse = coursesRepository.findById(savedCourse.getId());
        assertThat(foundCourse).isPresent();
        assertThat(foundCourse.get().getName()).isEqualTo(course.getName());
    }
}