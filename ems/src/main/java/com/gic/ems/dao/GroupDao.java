package com.gic.ems.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.entity.EmpGroup;

@Repository
public interface GroupDao extends JpaRepository<EmpGroup, Long> {
	 Optional<EmpGroup> findById(Long id);
}