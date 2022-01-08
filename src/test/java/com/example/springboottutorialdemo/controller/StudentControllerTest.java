package com.example.springboottutorialdemo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springboottutorialdemo.entity.StudentEntity;
import com.example.springboottutorialdemo.service.StudentService;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	private StudentEntity student;

	@BeforeEach
	void setup() {
		student = new StudentEntity(1, "abc", 101, "hyd");
	}

	@Test
	void testSaveStudent() throws Exception {
		StudentEntity studentEntity = new StudentEntity(1, "abc", 101, "hyd");
		Mockito.when(studentService.addStudent(studentEntity)).thenReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.post("/student/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + 
						"  \"id\": 1,\r\n" + 
						"  \"name\": \"abc\",\r\n" + 
						"  \"rollNo\": 101,\r\n" + 
						"  \"address\": \"hyd\"\r\n" + 
						"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
