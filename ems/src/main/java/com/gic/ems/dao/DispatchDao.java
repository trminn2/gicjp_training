package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.entity.Dispatch;

/**
 * The Interface DispatchDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.dao </BR>
 *        DispatchDao.java </BR>
 */
@Repository
public interface DispatchDao extends JpaRepository<Dispatch, Long> {

}