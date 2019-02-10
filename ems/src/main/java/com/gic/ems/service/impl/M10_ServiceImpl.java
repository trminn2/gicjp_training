package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gic.ems.common.type.DateFormat;
import com.gic.ems.common.utility.CommonUtility;
import com.gic.ems.common.utility.DateUtility;
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
				.findAllCustomSearch(new Specification<DispatchDepartment>() {
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
						List<Predicate> predicates = new ArrayList<>();
						if (StringUtils.isNotBlank(model.getCompanyName())) {
							predicates.add(cb.like(root.get("company.companyName"), model.getCompanyName()));
						}
						if (StringUtils.isNotBlank(model.getDestinationName())) {
							predicates.add(cb.like(root.get("dispatchDepartmentName"), model.getDestinationName()));
						}
						if (StringUtils.isNotBlank(model.getName())) {
							predicates.add(cb.like(root.get("contactPersonFirstName"), model.getName()));
							predicates.add(cb.like(root.get("contactPersonLastName"), model.getName()));
							predicates.add(cb.like(root.get("contactPersonFirstNameKana"), model.getName()));
							predicates.add(cb.like(root.get("contactPersonLastNameKana"), model.getName()));
						}
						// TODO edit date format after the UI calendar change
						if (StringUtils.isNotBlank(model.getStartDate())
								&& StringUtils.isNotBlank(model.getEndDate())) {
							predicates.add(cb.between(root.get("dispatches.dispatchStartDate"),
									DateUtility.getInstance().convertStringToLocaleDate(model.getStartDate(),
											DateFormat.DDMMYYYY),
									DateUtility.getInstance().convertStringToLocaleDate(model.getEndDate(),
											DateFormat.DDMMYYYY)));
							predicates.add(cb.between(root.get("dispatches.dispatchEndDate"),
									DateUtility.getInstance().convertStringToLocaleDate(model.getStartDate(),
											DateFormat.DDMMYYYY),
									DateUtility.getInstance().convertStringToLocaleDate(model.getEndDate(),
											DateFormat.DDMMYYYY)));

							// TODO edit date format after the UI calendar change
						} else if (StringUtils.isNotBlank(model.getStartDate())) {
							predicates.add(
									cb.greaterThan(root.get("dispatches.dispatchStartDate"), DateUtility.getInstance()
											.convertStringToLocaleDate(model.getStartDate(), DateFormat.DDMMYYYY)));
							// TODO edit date format after the UI calendar change
						} else if (StringUtils.isNotBlank(model.getEndDate())) {
							predicates.add(cb.lessThan(root.get("dispatches.dispatchEndDate"), DateUtility.getInstance()
									.convertStringToLocaleDate(model.getEndDate(), DateFormat.DDMMYYYY)));
						}
						return cb.or(predicates.toArray(new Predicate[0]));
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