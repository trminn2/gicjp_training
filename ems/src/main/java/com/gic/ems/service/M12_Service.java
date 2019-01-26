package com.gic.ems.service;

import java.util.Optional;
import com.gic.ems.entity.Employee;

public interface M12_Service {
	
	/**
	 * findById.
	 *
	 * @param i the employee Id
	 */
	public Optional<Employee> findById(Long id);

}
