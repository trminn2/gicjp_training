package com.gic.ems.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M14_EmpHakenCreateModel.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M14_EmpHakenCreateModel.
 */
@Getter
@Setter

/**
 * Instantiates a new m 14 emp haken create model.
 */
@NoArgsConstructor
public class M14_EmpHakenModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The company id. */
	private String companyId;

	/** The employee id. */
	private String employeeId;

	/** The employee name. */
	private String employeeName;

	/** The group id. */
	private String groupId;

	/** The dispatch dept. */
	private String dispatchDept;

	/** The dispatch start date. */
	private String dispatchStartDate;

	/** The dispatch end date. */
	private String dispatchEndDate;

	/** The income. */
	private String income;

	/**
	 * Instantiates a new m 14 emp haken create model.
	 *
	 * @param id                the id
	 * @param uuid              the uuid
	 * @param companyId         the company id
	 * @param employeeId        the employee id
	 * @param employeeName      the employee name
	 * @param groupId           the group id
	 * @param dispatchDept      the dispatch dept
	 * @param dispatchStartDate the dispatch start date
	 * @param dispatchEndDate   the dispatch end date
	 * @param income            the income
	 */

	/**
	 * Builds the.
	 *
	 * @return M14_EmpHakenCreateModel
	 */
	@Builder
	public M14_EmpHakenModel(Long id, String uuid, String companyId, String employeeId, String employeeName,
			String groupId, String dispatchDept, String dispatchStartDate, String dispatchEndDate, String income) {
		super(id, uuid);
		this.companyId = companyId;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.groupId = groupId;
		this.dispatchDept = dispatchDept;
		this.dispatchStartDate = dispatchStartDate;
		this.dispatchEndDate = dispatchEndDate;
		this.income = income;
	}
}