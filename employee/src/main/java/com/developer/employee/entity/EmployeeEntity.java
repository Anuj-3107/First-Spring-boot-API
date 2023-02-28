package com.developer.employee.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
//import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;



@Entity
@Table(name="employee")

public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private long id;
	
	@Column(name="emp_name")
	@NotEmpty
    @Size(min = 2, max = 50, message = "Must be between 2-50 characters")
	private String name;
	
	
	@Column(name="emp_gender")
	@NotEmpty
	private String gender;
	
	@Column(name="emp_dob")
	@NotNull(message = "Can't be empty")
    @Past(message = "Date of birth must be past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
