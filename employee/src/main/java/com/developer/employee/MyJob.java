package com.developer.employee;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.developer.employee.entity.EmployeeEntity;
import com.developer.employee.repository.EmployeeRepository;

public class MyJob implements Job{
	
	public EmployeeRepository employeeRepository;
	public MyJob(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("I am running automatically from MyJob.");
		
		List<EmployeeEntity> users = employeeRepository.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched from MyJob: " + users.size());
		for(EmployeeEntity user:users) {
			System.out.println(user.getName());
		}
		
		
	}

}
