package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gic.ems.entity.Company;

public interface CompanyDao extends JpaRepository<Company, Long> {

}
