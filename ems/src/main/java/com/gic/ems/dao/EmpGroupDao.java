package com.gic.ems.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.EmpGroup;

import lombok.NonNull;

/**
 * The Interface GroupDao.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.dao </BR>
 *        GroupDao.java </BR>
 */
@Repository
public interface EmpGroupDao extends JpaRepository<EmpGroup, Long> {

	/**
	 * Find by delete flag.
	 *
	 * @param active the active
	 * @return Collection
	 */
	Collection<EmpGroup> findByDeleteFlag(@NonNull DeleteFlag active);

	/**
	 * Find by id and delete flag.
	 *
	 * @param id         the id
	 * @param deleteFlag the delete flag
	 * @return Optional
	 */
	Optional<EmpGroup> findByIdAndDeleteFlag(@NonNull Long id, @NonNull DeleteFlag deleteFlag);
}