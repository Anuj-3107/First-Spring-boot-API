package com.developer.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developer.employee.entity.EmployeeEntity;
import com.developer.employee.repository.EmployeeRepository;
import com.developer.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		//super();
		this.employeeRepository = employeeRepository;  
	}

	@Override
	public List<EmployeeEntity> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Optional<EmployeeEntity> findById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}
	
}
