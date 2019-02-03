package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.entity.Certificate;

/**
 * The Interface CertificateDao.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface CertificateDao.
 */
@Repository
public interface CertificateDao extends JpaRepository<Certificate, Long> {

}