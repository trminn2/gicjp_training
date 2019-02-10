package com.gic.ems.common.utility;

import org.apache.commons.lang3.StringUtils;

import com.gic.ems.common.constant.Constant;

/**
 * The Class CommonUtility.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 11, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.common.utility </BR>
 *        CommonUtility.java </BR>
 */
public final class CommonUtility {

	/** The common utility. */
	private volatile static CommonUtility commonUtility;

	/**
	 * Instantiates a new common utility.
	 */
	private CommonUtility() {
		super();
	}

	/**
	 * Gets the single instance of CommonUtility.
	 *
	 * @return single instance of CommonUtility
	 */
	public static CommonUtility getInstance() {
		if (null == CommonUtility.commonUtility) {
			synchronized (CommonUtility.class) {
				CommonUtility.commonUtility = new CommonUtility();
			}
		}
		return CommonUtility.commonUtility;
	}

	/**
	 * Concat name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return String
	 */
	public String concatName(String firstName, String lastName) {
		return (StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName))
				? new StringBuilder(firstName).append(Constant.SPACE).append(lastName).toString()
				: (StringUtils.isNotBlank(firstName) && StringUtils.isBlank(lastName)) ? firstName : lastName;
	}

}