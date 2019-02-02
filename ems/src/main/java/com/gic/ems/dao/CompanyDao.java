package com.gic.ems.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.entity.Company;

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

	Collection<Company> findAllByDeleteFlag(DeleteFlag deleteFlag);

	Company findByIdAndDeleteFlag(String companyId, DeleteFlag active);
}