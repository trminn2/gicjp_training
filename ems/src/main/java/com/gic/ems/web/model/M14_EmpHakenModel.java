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

	/** The company code. */
	private Long companyCode;

	/** The employee code. */
	private String employeeCode;

	/** The employee name. */
	// private String employeeName;

	/** The group id. */
	private Long groupId;

	/** The dispatch dept. */
	private Long dispatchDeptId;

	/** The dispatch start date. */
	private String dispatchStartDate;

	/** The dispatch end date. */
	private String dispatchEndDate;

	/** The income. */
	private String income;

	@Builder
	public M14_EmpHakenModel(Long id, String uuid, Long companyCode, String employeeCode, Long groupId,
			Long dispatchDeptId, String dispatchStartDate, String dispatchEndDate, String income) {
		super(id, uuid);
		this.companyCode = companyCode;
		this.employeeCode = employeeCode;
		this.groupId = groupId;
		this.dispatchDeptId = dispatchDeptId;
		this.dispatchStartDate = dispatchStartDate;
		this.dispatchEndDate = dispatchEndDate;
		this.income = income;
	}
}
	