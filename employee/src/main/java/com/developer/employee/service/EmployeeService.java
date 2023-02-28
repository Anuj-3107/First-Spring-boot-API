package com.developer.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.developer.employee.entity.EmployeeEntity;


public interface EmployeeService {
	List<EmployeeEntity> findAll(Integer pageNumber, Integer pageSize, String sortBy);
	Optional<EmployeeEntity> findById(long id);
	EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
	void deleteEmployee(long id);
	List<EmployeeEntity> searchEmployeeByKey(String keyword);
}
