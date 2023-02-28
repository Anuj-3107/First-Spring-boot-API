package com.developer.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.developer.employee.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	
	@Query("select e from EmployeeEntity e where concat(e.name, e.id, e.address) like %?1%")
	List<EmployeeEntity> SearchEmployeeByKeyword(String keyword);
}
