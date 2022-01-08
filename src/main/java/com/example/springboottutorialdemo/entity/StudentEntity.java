/**
 * 
 */
package com.example.springboottutorialdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@Column(name = "ID")
	private Integer id;

	@NotBlank(message = "Please add student name.")
	@Column(name = "NAME")
	private String name;

	@Column(name = "ROLL_NUMBER")
	private Integer rollNo;

	@Column(name = "ADDRESS")
	private String address;

	public StudentEntity() {

	}

	public StudentEntity(String name, Integer rollNo, String address) {
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	
	public StudentEntity(Integer id, @NotBlank(message = "Please add student name.") String name, Integer rollNo,
			String address) {
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", address=" + address + "]";
	}
}
