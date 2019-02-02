package com.gic.ems.common.utility;

import io.micrometer.core.lang.NonNull;

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

	/** The Constant COMPANY_CODE. */
	private static final String COMPANY_CODE = "COM";

	/** The Constant EMPLOYEE_CODE. */
	private static final String EMPLOYEE_CODE = "EMP";

	/** The Constant CODE_0. */
	private static final String CODE_0 = "0";

	/** The Constant CODE_00. */
	private static final String CODE_00 = "00";

	/** The Constant CODE_000. */
	private static final String CODE_000 = "000";

	/** The Constant CODE_0000. */
	private static final String CODE_0000 = "0000";

	/** The code utility. */
	private volatile static CodeUtility codeUtility;

	/**
	 * Gets the single instance of CodeUtility.
	 *
	 * @return CodeUtility
	 */
	public static final CodeUtility getInstance() {
		if (null == codeUtility) {
			synchronized (DateUtility.class) {
				codeUtility = new CodeUtility();
			}
		}
		return codeUtility;
	}

	/**
	 * Generate company code.
	 *
	 * @param companyId the company id
	 * @return String
	 */
	public String generateCompanyCode(@NonNull final Long companyId) {
		return new StringBuilder(COMPANY_CODE).append(this.getCode(companyId)).toString();
	}

	/**
	 * Generate employee code.
	 *
	 * @param employeeId the employee id
	 * @return String
	 */
	public String generateEmployeeCode(@NonNull final Long employeeId) {
		return new StringBuilder(EMPLOYEE_CODE).append(this.getCode(employeeId)).toString();
	}

	/**
	 * Gets the code.
	 *
	 * @param companyId the company id
	 * @return String
	 */
	private String getCode(@NonNull final Long companyId) {
		int id = companyId.intValue() + 1;
		return new StringBuilder((id < 10) ? CODE_0000
				: (id < 100) ? CODE_000 : (id < 1000) ? CODE_00 : (id < 10000) ? CODE_0 : companyId.toString())
						.append(String.valueOf(id)).toString();
	}
}