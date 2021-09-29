package com.example.springdatajpafull.repository;

import com.example.springdatajpafull.entity.Course;
import com.example.springdatajpafull.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course =
                Course.builder()
                        .title("Spring Boot")
                        .credit(10)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.bealdung.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }
    
    @Test
    public void getCourseMaterials(){
        List<CourseMaterial> courseMaterials = 
                courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }

    @Test
    public void getCourseMaterialsByCourseId(){

        CourseMaterial courseMaterial =
                courseMaterialRepository.findByCourseCourseId(1);

        System.out.println("courseMaterial = " + courseMaterial);
    }

}