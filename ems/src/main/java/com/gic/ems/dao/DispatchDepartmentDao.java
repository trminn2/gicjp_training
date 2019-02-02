package com.gic.ems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.DispatchDepartment;

import lombok.NonNull;

/**
 * The Class DispatchDepartmentDao.
 *
 * @author ThetThetKhine Feb 2, 2019 </BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems system</BR>
 *        com.gic.ems.dao </BR>
 *        DispatchDepartmentDao.java </BR>
 */
public interface DispatchDepartmentDao extends JpaRepository<DispatchDepartment, Long> {

	DispatchDepartment findByIdAndDeleteFlag(@NonNull Long id, DeleteFlag active);
}