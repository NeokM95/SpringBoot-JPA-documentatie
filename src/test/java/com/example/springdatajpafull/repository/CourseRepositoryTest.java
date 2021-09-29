package com.example.springdatajpafull.repository;

import com.example.springdatajpafull.entity.Course;
import com.example.springdatajpafull.entity.Student;
import com.example.springdatajpafull.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void getCourseByTitle() {
        Optional<Course> course =
                courseRepository.findCourseByTitle("Spring Boot");

        System.out.println("course = " + course);
    }


    @Test
    public void setTeacherToCourse(){
        courseRepository.setTeacherToCourse(
                        3L,
                        2L
                );
    }

    @Test
    public void getCourseById(){
        Optional<Course> course =
                courseRepository.findById(1L);

        System.out.println("course = " + course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Peter")
                .lastName("Anema")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void getCoursesByTeacherId(){
        List<Course> courses =
                courseRepository.getCoursesByTeacherTeacherId(3L);

        System.out.println("courses = " + courses);
    }

    @Test
    public void getCourseByTeacherFirstName(){
        List<Course> courses =
                courseRepository.getCoursesByTeacherFirstName("Nova");

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();


        System.out.println("courses = " + courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);

    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );

        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTeacher =
                PageRequest.of(
                        0,
                        5,
                        Sort.by("TeacherFirstName")
                );
        
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        5,
                        Sort.by("credit")
                                .descending()
                                .and(Sort.by("title"))
                );
        
        List<Course> courses =
                courseRepository.findAll(sortByTeacher).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Nova")
                .lastName("Eken")
                .build();

        Student student = Student.builder()
                .firstName("Elwyn")
                .lastName("de Neve")
                .emailId("Elwyn@gmail.com")
                .build();

        Course course = Course.builder()
                .title("React")
                .credit(8)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }

}