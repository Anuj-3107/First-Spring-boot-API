package com.developer.employee.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")

public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private long id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_gender")
	private String gender;
	
	@Column(name="emp_dob")
	private Date dob;
	
	@Column(name="emp_address")
	private String address;
	
	
	public EmployeeEntity() {
	}


	public EmployeeEntity(long id, String name, String gender, Date dob, String address) {
		//super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
