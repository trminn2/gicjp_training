package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gic.ems.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
}
