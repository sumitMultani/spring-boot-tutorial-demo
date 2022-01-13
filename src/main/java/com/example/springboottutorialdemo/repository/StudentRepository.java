package com.example.springboottutorialdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboottutorialdemo.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	public List<StudentEntity> findByName(String name);
}
