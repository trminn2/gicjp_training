package com.gic.ems.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.Company;

import lombok.NonNull;

/**
 * The Class EmsApplication.
 *
 * @author ThetThetKhine Feb 02, 2019 </BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems system</BR>
 *        com.gic.ems </BR>
 *        EmsApplication.java </BR>
 */
@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {

	/**
	 * Find all by delete flag.
	 *
	 * @param deleteFlag the delete flag
	 * @return Collection
	 */
	Collection<Company> findAllByDeleteFlag(@NonNull DeleteFlag deleteFlag);

	/**
	 * Find by id and delete flag.
	 *
	 * @param id         the id
	 * @param deleteFlag the delete flag
	 * @return Company
	 */
	Company findByIdAndDeleteFlag(@NonNull Long id, @NonNull DeleteFlag deleteFlag);
}