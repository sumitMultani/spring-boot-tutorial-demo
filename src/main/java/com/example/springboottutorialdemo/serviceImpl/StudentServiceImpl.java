package com.example.springboottutorialdemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottutorialdemo.entity.StudentEntity;
import com.example.springboottutorialdemo.exception.StudentNotFoundException;
import com.example.springboottutorialdemo.repository.StudentRepository;
import com.example.springboottutorialdemo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public StudentEntity addStudent(StudentEntity student) {
		return studentRepository.save(student);  
	}

	@Override
	public List<StudentEntity> getAllStudent() {
		return studentRepository.findAll(); 
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		 Optional<StudentEntity> studentOpt = studentRepository.findById(id);
		 if(!studentOpt.isPresent()) {
			 throw new StudentNotFoundException("Student with id : "+id+" doesn't exist.");
		 }
		 return studentOpt.get();
	}

}
