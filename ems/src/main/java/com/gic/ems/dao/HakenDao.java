package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gic.ems.entity.DispatchDepartment;

public interface HakenDao extends JpaRepository<DispatchDepartment, Long> {

}
