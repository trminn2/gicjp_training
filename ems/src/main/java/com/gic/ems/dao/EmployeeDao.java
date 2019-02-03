package com.gic.ems.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.Employee;

import lombok.NonNull;

/**
 * The Interface EmployeeDao.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Interface EmployeeDao.
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	/**
	 * Find all by delete flag.
	 *
	 * @param deleteFlag the delete flag
	 * @return List
	 */
	@Query(value = "SELECT * FROM employee LEFT JOIN empgroup ON employee.empGroup_id = empgroup.id WHERE employee.deleteflag = ?1", nativeQuery = true)
	List<Employee> findAllByDeleteFlag(@NonNull DeleteFlag deleteFlag);

	/**
	 * Find by employee code and delete flag.
	 *
	 * @param employeeId the employee id
	 * @param active     the active
	 * @return Employee
	 */
	Employee findByEmployeeCodeAndDeleteFlag(@NonNull String employeeId, @NonNull DeleteFlag active);

	/**
	 * Find by employee code and delete flag containing.
	 *
	 * @param employeeCode the employee code
	 * @param active       the active
	 * @return Collection
	 */
	Collection<Employee> findByEmployeeCodeAndDeleteFlagContaining(@NonNull String employeeCode,
			@NonNull DeleteFlag active);

	Optional<Employee> findByIdAndDeleteFlag(@NonNull Long id, DeleteFlag active);
}