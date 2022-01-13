package com.example.springboottutorialdemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottutorialdemo.entity.StudentEntity;
import com.example.springboottutorialdemo.exception.StudentNotFoundException;
import com.example.springboottutorialdemo.repository.StudentRepository;
import com.example.springboottutorialdemo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

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
		if (!studentOpt.isPresent()) {
			throw new StudentNotFoundException("Student with id : " + id + " doesn't exist.");
		}
		return studentOpt.get();
	}

	@Override
	public StudentEntity updateStudentById(StudentEntity student, Integer id) {
		Optional<StudentEntity> studentOpt = studentRepository.findById(id);
		if (!studentOpt.isPresent()) {
			throw new StudentNotFoundException("Student with id : " + id + " doesn't exist.");
		}
		StudentEntity studentEntity = studentOpt.get();
		if (StringUtils.isNotEmpty(student.getName())) {
			studentEntity.setName(student.getName());
		}
		if (StringUtils.isNotEmpty(student.getAddress())) {
			studentEntity.setAddress(student.getAddress());
		}
		if (ObjectUtils.isNotEmpty(student.getRollNo())) {
			studentEntity.setRollNo(student.getRollNo());
		}
		return studentRepository.save(studentEntity);
	}

	@Override
	public StudentEntity deleteStudentById(Integer id) {
		// first will check if student with id exist or not.
		Optional<StudentEntity> studentOpt = studentRepository.findById(id);
		if (!studentOpt.isPresent()) {
			throw new StudentNotFoundException("Student with id : " + id + " doesn't exist.");
		}
		studentRepository.delete(studentOpt.get());
		return null;
	}

	@Override
	public List<StudentEntity> getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

}
