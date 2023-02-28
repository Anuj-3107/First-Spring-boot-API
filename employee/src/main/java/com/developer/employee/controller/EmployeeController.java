package com.developer.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developer.employee.entity.EmployeeEntity;
import com.developer.employee.service.EmployeeService;

import javax.validation.Valid;

@RestController

public class EmployeeController {
	
	@Autowired
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		//super();
		this.employeeService = employeeService;
	}
	@GetMapping("/")
	public String welcome()
	{
		return "This is welcome page";
	}
	
	@GetMapping("/employee")
	public List<EmployeeEntity> findAllEmployee(
			@RequestParam(value="pageNumber", defaultValue="0", required=false) Integer pageNumber, 
			@RequestParam(value="pageSize", defaultValue="5", required=false) Integer pageSize, 
			@RequestParam(value="sortBy", defaultValue="id", required=false) String sortBy){
		
		return employeeService.findAll(pageNumber, pageSize, sortBy);
	}
	
	@GetMapping("/employee/{id}")
	public Optional findEmployeeById(@PathVariable("id") long id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("/employee")
	public EmployeeEntity saveEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
		return  employeeService.saveEmployee(employeeEntity);
	}
	
	@PutMapping("/employee") 
	public EmployeeEntity updateEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
		return employeeService.saveEmployee(employeeEntity);
	}
	
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
	}
	
	
	@GetMapping("/employee/search/{keyword}")
	public List<EmployeeEntity> findEmployeeByKey(@PathVariable("keyword") String keyword)
	{
		return employeeService.searchEmployeeByKey(keyword);
	}
	 
}
