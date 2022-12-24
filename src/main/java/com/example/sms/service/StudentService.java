package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	List<Student> getAllStudentsByNameOrEmail(String nameOrEmail);
	Student saveStudent(Student student);
	Student getStudentById(Long studentId);
	Student updateStudent(Student student);
	void deleteStudent(Long studentId);
}
