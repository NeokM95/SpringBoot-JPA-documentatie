package com.example.springdatajpafull.repository;

import com.example.springdatajpafull.entity.Guardian;
import com.example.springdatajpafull.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Esli")
                .email("EFriemann@hotmail.com")
                .mobile("06-12345678")
                .build();

        Student student = Student.builder()
                .firstName("Jason")
                .lastName("Post")
                .emailId("JJPost@hotmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){

        List<Student> students =
                studentRepository.findByFirstName("Koen");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students =
                studentRepository.findByFirstNameContaining("Ko");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){

        List<Student> students =
                studentRepository.findByGuardianName("Bart");

        System.out.println("students = " + students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "lynn_mensink@hotmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress(){
        String studentName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "lynn_mensink@hotmail.com"
                );

        System.out.println("studentName = " + studentName);
    }

    @Test
    public void getStudentByEmailAdressNative(){
        Student student =
                studentRepository.getStudentByEmailAdressNative(
                        "lynn_mensink@hotmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAdressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "lynn_mensink@hotmail.com"
                );

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Klaas",
                "koen_mensink@hotmail.com"

        );

    }

}