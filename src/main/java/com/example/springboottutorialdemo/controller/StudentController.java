package com.example.springboottutorialdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboottutorialdemo.entity.StudentEntity;
import com.example.springboottutorialdemo.service.StudentService;

@RestController
@RequestMapping("/student/")
public class StudentController {

	private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public StudentEntity addStudent(@Valid @RequestBody StudentEntity student) {
		LOGGER.info("Inside STudentController addStudent method, RequestBody : {} ", student);
		return studentService.addStudent(student);
	}
	
	@GetMapping
	public List<StudentEntity> getAllStudent() {
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{student-id}")
	public StudentEntity getStudentById(@PathVariable("student-id") Integer id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/{student-id}")
	public StudentEntity updateStudentById(@Valid @RequestBody StudentEntity student, @PathVariable("student-id") Integer id) {
		return studentService.updateStudentById(student, id);
	}
	
	@DeleteMapping("/{student-id}")
	public StudentEntity deleteStudentById(@PathVariable("student-id") Integer id) {
		return studentService.deleteStudentById(id);
	}
	
	@GetMapping("/name/{student-name}")
	public List<StudentEntity> getStudentByName(@PathVariable("student-name") String name) {
		return studentService.getStudentByName(name);
	}
} 
