package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.entity.Dispatch;

public interface DispatchDao extends JpaRepository<Dispatch, Long>  {

}
