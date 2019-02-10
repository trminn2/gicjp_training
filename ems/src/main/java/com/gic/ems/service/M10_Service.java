package com.gic.ems.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.gic.ems.common.type.DateFormat;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.common.utility.DateUtility;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.web.model.M10_HakenInfoSearchModel;
import com.gic.ems.web.model.M10_HakenInfoSearchResultModel;

import lombok.NonNull;

/**
 * The Interface M10_Service.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.service </BR>
 *        M10_Service.java </BR>
 */
public interface M10_Service {

	/**
	 * Search.
	 *
	 * @param model the model
	 * @return Collection
	 */
	Collection<M10_HakenInfoSearchResultModel> findAll(@NonNull M10_HakenInfoSearchModel model);

	/**
	 * Gets the find all predicates.
	 *
	 * @param root  the root
	 * @param query the query
	 * @param cb    the cb
	 * @param model the model
	 * @return the find all predicates
	 */
	default Predicate createCustomFilter(Root<DispatchDepartment> root, CriteriaQuery<?> query, CriteriaBuilder cb,
			@NonNull M10_HakenInfoSearchModel model) {
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
		if (StringUtils.isNotBlank(model.getStartDate()) && StringUtils.isNotBlank(model.getEndDate())) {
			predicates.add(cb.between(root.get("dispatches.dispatchStartDate"),
					DateUtility.getInstance().convertStringToLocaleDate(model.getStartDate(), DateFormat.DDMMYYYY),
					DateUtility.getInstance().convertStringToLocaleDate(model.getEndDate(), DateFormat.DDMMYYYY)));
			predicates.add(cb.between(root.get("dispatches.dispatchEndDate"),
					DateUtility.getInstance().convertStringToLocaleDate(model.getStartDate(), DateFormat.DDMMYYYY),
					DateUtility.getInstance().convertStringToLocaleDate(model.getEndDate(), DateFormat.DDMMYYYY)));

			// TODO edit date format after the UI calendar was changed.
		} else if (StringUtils.isNotBlank(model.getStartDate())) {
			predicates.add(cb.greaterThan(root.get("dispatches.dispatchStartDate"),
					DateUtility.getInstance().convertStringToLocaleDate(model.getStartDate(), DateFormat.DDMMYYYY)));
			// TODO edit date format after the UI calendar was changed.
		} else if (StringUtils.isNotBlank(model.getEndDate())) {
			predicates.add(cb.lessThan(root.get("dispatches.dispatchEndDate"),
					DateUtility.getInstance().convertStringToLocaleDate(model.getEndDate(), DateFormat.DDMMYYYY)));
		}
		return ((CriteriaBuilder) cb.or(predicates.toArray(new Predicate[0]))).equal(root.get("deleteFlag"),
				DeleteFlag.ACTIVE);
	}
}