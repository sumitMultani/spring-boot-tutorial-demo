package com.example.springboottutorialdemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.springboottutorialdemo.entity.StudentEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setup() {
		StudentEntity studentEntity = new StudentEntity(44, "abc", 9999, "dlh");
		entityManager.persist(studentEntity);
	}

	@Test
	public void findByStudentId() {
		StudentEntity student = studentRepository.findById(44).get();
		assertEquals("abc", student.getName());
	}

}
