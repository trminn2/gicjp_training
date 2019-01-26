package com.gic.ems.common.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class DateUtils.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class DateUtils.
 */
public class DateUtility {

	/** The date utils. */
	private volatile static DateUtility dateUtils;

	/**
	 * Instantiates a new date utils.
	 */
	private DateUtility() {
		super();
	}

	public static DateUtility getInstance() {
		if (null == dateUtils) {
			synchronized (DateUtility.class) {
				dateUtils = new DateUtility();
			}
		}
		return dateUtils;
	}

	/**
	 * Convert string to locale date.
	 *
	 * @param stringDate the string date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public LocalDate convertStringToLocaleDate(final String stringDate, final String dateFormat) {
		return null;
	}

	/**
	 * Convert locale date to string.
	 *
	 * @param date       the date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public LocalDate convertLocaleDateToString(final LocalDate date, final String dateFormat) {
		return null;
	}

	/**
	 * Convert string to locale date time.
	 *
	 * @param stringDate the string date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public LocalDate convertStringToLocaleDateTime(final String stringDate, final String dateFormat) {
		return null;
	}

	/**
	 * Convert locale date time to string.
	 *
	 * @param date       the date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public LocalDate convertLocaleDateTimeToString(final LocalDateTime date, final String dateFormat) {
		return null;
	}
}