package com.example.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value="SELECT * FROM students student WHERE student.first_name like %:nameOrEmail% or student.last_name like %:nameOrEmail% or student.email like %:nameOrEmail%", nativeQuery=true)
    List<Student> getAllStudentsByNameOrEmail(@Param("nameOrEmail") String nameOrEmail);
}
