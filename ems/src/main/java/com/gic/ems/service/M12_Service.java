package com.gic.ems.service;

import java.util.Optional;
import com.gic.ems.entity.Employee;

/**
 * The Interface M12_Service.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface M12_Service.
 */
public interface M12_Service {

	/**
	 * findById.
	 *
	 * @param id the id
	 * @return Optional
	 */
	public Optional<Employee> findById(Long id);
}