package com.gic.ems.common.utility;

import com.gic.ems.common.constant.Constant;

import lombok.NonNull;

/**
 * The Class CodeUtility.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 2, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.common.utility </BR>
 *        CodeUtility.java </BR>
 */
public class CodeUtility {

	/** The code utility. */
	private volatile static CodeUtility codeUtility;

	/**
	 * Gets the single instance of CodeUtility.
	 *
	 * @return CodeUtility
	 */
	public static final CodeUtility getInstance() {
		if (null == CodeUtility.codeUtility) {
			synchronized (CodeUtility.class) {
				CodeUtility.codeUtility = new CodeUtility();
			}
		}
		return CodeUtility.codeUtility;
	}

	/**
	 * Generate company code.
	 *
	 * @param companyId the company id
	 * @return String
	 */
	public String generateCompanyCode(@NonNull final Long companyId) {
		return new StringBuilder(Constant.COMPANY_CODE).append(this.getCode(companyId)).toString();
	}

	/**
	 * Generate employee code.
	 *
	 * @param employeeId the employee id
	 * @return String
	 */
	public String generateEmployeeCode(@NonNull final Long employeeId) {
		return new StringBuilder(Constant.EMPLOYEE_CODE).append(this.getCode(employeeId)).toString();
	}

	/**
	 * Gets the code.
	 *
	 * @param companyId the company id
	 * @return String
	 */
	private String getCode(@NonNull final Long companyId) {
		int id = companyId.intValue() + 1;
		return new StringBuilder((id < 10) ? Constant.CODE_0000
				: (id < 100) ? Constant.CODE_000
						: (id < 1000) ? Constant.CODE_00 : (id < 10000) ? Constant.CODE_0 : companyId.toString())
								.append(String.valueOf(id)).toString();
	}
}