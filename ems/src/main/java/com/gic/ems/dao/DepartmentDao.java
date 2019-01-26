package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.entity.Department;

/**
 * The Interface DepartmentDao.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface DepartmentDao.
 */
public interface DepartmentDao extends JpaRepository<Department, Long> {

}