package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gic.ems.common.utility.CommonUtility;
import com.gic.ems.dao.DispatchDepartmentDao;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.service.M10_Service;
import com.gic.ems.web.model.M10_HakenInfoSearchModel;
import com.gic.ems.web.model.M10_HakenInfoSearchResultModel;

/**
 * The Class M10_ServiceImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.service.impl </BR>
 *        M10_ServiceImpl.java </BR>
 */
@Service
public class M10_ServiceImpl implements M10_Service {

	/** The dispatch department. */
	private DispatchDepartmentDao dispatchDepartmentDao;

	/**
	 * Sets the dispatch department.
	 *
	 * @param dispatchDepartmentDao the new dispatch department
	 */
	@Autowired
	public void setDispatchDepartmentDao(DispatchDepartmentDao dispatchDepartmentDao) {
		this.dispatchDepartmentDao = dispatchDepartmentDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M10_Service#search(com.gic.ems.web.model.
	 * M10_HakenInfoSearchModel)
	 */
	@Override
	public Collection<M10_HakenInfoSearchResultModel> findAll(M10_HakenInfoSearchModel model) {
		Collection<DispatchDepartment> dispatchDepartments = this.dispatchDepartmentDao
				.findAll(new Specification<DispatchDepartment>() {
					/** The Constant serialVersionUID. */
					private static final long serialVersionUID = 1L;

					/*
					 * (non-Javadoc)
					 *
					 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.
					 * persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery,
					 * javax.persistence.criteria.CriteriaBuilder)
					 */
					@Override
					public Predicate toPredicate(Root<DispatchDepartment> root, CriteriaQuery<?> query,
							CriteriaBuilder cb) {
						return M10_ServiceImpl.this.createCustomFilter(root, query, cb, model);
					}
				});
		Collection<M10_HakenInfoSearchResultModel> m10_HakenInfoSearchResultModels = new ArrayList<>();
		dispatchDepartments.forEach(dispatchDepartment -> {
			m10_HakenInfoSearchResultModels.add(M10_HakenInfoSearchResultModel.builder()
					.destinationName(dispatchDepartment.getDispatchDepartmentName())
					.companyName(dispatchDepartment.getCompany().getCompanyName())
					.kanjiName(CommonUtility.getInstance().concatName(dispatchDepartment.getContactPersonFirstName(),
							dispatchDepartment.getContactPersonLastName()))
					.kanaName(CommonUtility.getInstance().concatName(dispatchDepartment.getContactPersonFirstNameKana(),
							dispatchDepartment.getContactPersonLastNameKana()))
					.phone(dispatchDepartment.getContactPhone()).email(dispatchDepartment.getContactEmail())
					.address(dispatchDepartment.getAddress()).build());
		});
		return m10_HakenInfoSearchResultModels;
	}
}