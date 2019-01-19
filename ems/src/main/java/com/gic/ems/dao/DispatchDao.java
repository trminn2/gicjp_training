package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.entity.Dispatch;

@Repository
public interface DispatchDao extends JpaRepository<Dispatch, Long> {

}
