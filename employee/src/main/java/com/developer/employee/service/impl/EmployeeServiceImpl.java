package com.developer.employee.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
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
	public List<EmployeeEntity> findAll(Integer pageNumber, Integer pageSize, String sortBy) {
		Pageable p=PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		Page<EmployeeEntity> pageEmployee=employeeRepository.findAll(p);
		
		List<EmployeeEntity> allEmployees=pageEmployee.getContent();
		
		// TODO Auto-generated method stub
		return allEmployees;
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


	@Override
	public List<EmployeeEntity> searchEmployeeByKey(String keyword) {
		// TODO Auto-generated method stub
		List<EmployeeEntity> list=employeeRepository.SearchEmployeeByKeyword("%"+keyword+"%");
		return list;
	}
	
//	@Autowired
//	private UserDao dao;

	org.slf4j.Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	// schedule a job to add object in DB (Every 5 sec)
	
//	public void add2DBJob() {
//		EmployeeEntity user = new EmployeeEntity();
//		user.setName("user" + new Random().nextInt(374483));
//		user.setAddress("Amravati");
//		user.setGender("Male");
//		user.setDob("2000-");
//		employeeRepository.save(user);
//		System.out.println("add service call in " + new Date().toString());
//	}

	@Scheduled(fixedRate = 5000)
	public void fetchDBJob() {
		List<EmployeeEntity> users = employeeRepository.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched from Service: " + users.size());
		for(EmployeeEntity user:users) {
			System.out.println(user.getName());
		}
		log.info("users : {}", users);
		
	}
}
