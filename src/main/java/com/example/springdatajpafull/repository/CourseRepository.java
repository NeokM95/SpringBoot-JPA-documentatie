package com.example.springdatajpafull.repository;

import com.example.springdatajpafull.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    Optional<Course> findCourseByTitle(String title);

    @Modifying
    @Transactional
    @Query(
            value= "update course set teacher_id =?1 where course_id = ?2",
            nativeQuery = true
    )
    void setTeacherToCourse(Long teacherId, Long courseId);


    List<Course> getCoursesByTeacherTeacherId(Long teacherId);

    List<Course> getCoursesByTeacherFirstName(String firstName);
}
