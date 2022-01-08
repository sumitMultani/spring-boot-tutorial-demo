package com.example.springboottutorialdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboottutorialdemo.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}
