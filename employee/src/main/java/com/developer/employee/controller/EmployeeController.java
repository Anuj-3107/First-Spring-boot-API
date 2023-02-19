package com.developer.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.employee.entity.EmployeeEntity;
import com.developer.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		//super();
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public List<EmployeeEntity> findAllEmployee(){
		return employeeService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional findEmployeeById(@PathVariable("id") long id) {
		return employeeService.findById(id);
	}
	
	@PostMapping
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return  employeeService.saveEmployee(employeeEntity);
	}
	
	@PutMapping 
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.saveEmployee(employeeEntity);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
	}
	 
}
