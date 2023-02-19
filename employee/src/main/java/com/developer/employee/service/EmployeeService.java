package com.developer.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.employee.entity.EmployeeEntity;


public interface EmployeeService {
	List<EmployeeEntity> findAll();
	Optional<EmployeeEntity> findById(long id);
	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
	void deleteEmployee(long id);
}
