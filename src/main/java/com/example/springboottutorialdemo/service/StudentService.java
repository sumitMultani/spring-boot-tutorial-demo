package com.example.springboottutorialdemo.service;

import java.util.List;

import com.example.springboottutorialdemo.entity.StudentEntity;

public interface StudentService {

	StudentEntity addStudent(StudentEntity student);

	List<StudentEntity> getAllStudent();

	StudentEntity getStudentById(Integer id);

}
