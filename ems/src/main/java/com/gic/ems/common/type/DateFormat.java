package com.gic.ems.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Instantiates a new date format.
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 * ems system </BR>
 * com.gic.ems.common.type </BR>
 * DateFormat.java </BR>
 */

/**
 * Instantiates a new date format.
 *
 * @param format the format
 */
@AllArgsConstructor

/**
 * Instantiates a new date format.
 */
@NoArgsConstructor
public enum DateFormat {

	/** The dd/mm/yyyy format. */
	DDMMYYYY("dd/MM/yyyy"),

	/** The dd-mm-yyyy format. */
	DD_MM_YYYY("dd-MM-yyyy"),

	/** The yyyymmdd format. */
	YYYYMMDD("yyyy/MM/dd"),

	/** The yyyy-mm-dd format. */
	YYYY_MM_DD("yyyy-MM-dd"),

	/** The YYYY/MM/DD HH:mm:SS format. */
	YYYYMMDDHHmmSS("yyyy/MM/dd HH:mm:ss"),

	/** The YYYY-MM-DD HH:mm:SS format. */
	YYYY_MM_DD_HHmmSS("yyyy-MM-dd HH:mm:ss");

	/** The format. */
	@Getter
	@Setter
	@NonNull
	private String format;
}