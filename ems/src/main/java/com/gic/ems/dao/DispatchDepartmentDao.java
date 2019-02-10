package com.gic.ems.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

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
@Repository
public interface DispatchDepartmentDao
		extends JpaRepository<DispatchDepartment, Long>, JpaSpecificationExecutor<DispatchDepartment> {

	/**
	 * Find by delete flag.
	 *
	 * @param active the active
	 * @return Collection
	 */
	Collection<DispatchDepartment> findByDeleteFlag(@NonNull DeleteFlag active);

	/**
	 * Find by id and delete flag.
	 *
	 * @param id     the id
	 * @param active the active
	 * @return DispatchDepartment
	 */
	DispatchDepartment findByIdAndDeleteFlag(@NonNull Long id, @NonNull DeleteFlag active);

	/**
	 * Find all by delete flag.
	 *
	 * @param active the active
	 * @return Collection
	 */
	Collection<DispatchDepartment> findAllByDeleteFlag(@NonNull DeleteFlag active);
}