package com.gic.ems.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.Employee;

/**
 * The Interface EmployeeDao.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Interface EmployeeDao.
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	// employee list searching Thae
	@Query(value = "SELECT * FROM employee LEFT JOIN empgroup ON employee.empGroup_id = empgroup.id ", nativeQuery = true)
	List<Employee> findAll();

	Collection<Employee> findByEmployeeIdAndDeleteFlagContaining(String employeeId, DeleteFlag active);

	Employee findByEmployeeIdAndDeleteFlag(String employeeId, DeleteFlag active);
}