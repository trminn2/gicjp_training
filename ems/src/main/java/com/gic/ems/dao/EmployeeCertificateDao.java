package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.entity.EmployeeCertificate;

/**
 * The Interface EmployeeCertificateDao.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface EmployeeCertificateDao.
 */
public interface EmployeeCertificateDao extends JpaRepository<EmployeeCertificate, Long> {

}