package com.example.springdatajpafull.repository;

import com.example.springdatajpafull.entity.Course;
import com.example.springdatajpafull.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherWithCourses() {

        Course courseJpa = Course.builder()
                .title("JPA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Maarten")
                .lastName("Mensink")
                //.courses(List.of(courseJpa, courseJava))
                .build();

        teacherRepository.save(teacher);

    }

    @Test
    public void saveTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Joost")
                .lastName("Baardman")
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void getTeacherById() {
        Optional<Teacher> teacher = teacherRepository.findById(2L);

        System.out.println("teacher = " + teacher);
    }


}