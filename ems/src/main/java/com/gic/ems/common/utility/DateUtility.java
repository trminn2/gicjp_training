package com.gic.ems.common.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.NonNull;

/**
 * The Class DateUtils.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class DateUtils.
 */
public final class DateUtility {

	/** The date utils. */
	private volatile static DateUtility dateUtils;

	/**
	 * Instantiates a new date utils.
	 */
	private DateUtility() {
		super();
	}

	/**
	 * Gets the single instance of DateUtility.
	 *
	 * @return single instance of DateUtility
	 */
	public static final DateUtility getInstance() {
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
	public final LocalDate convertStringToLocaleDate(@NonNull final String stringDate,
			@NonNull final String dateFormat) {
		return null;
	}

	/**
	 * Convert locale date to string.
	 *
	 * @param date       the date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public final LocalDate convertLocaleDateToString(@NonNull final LocalDate date, @NonNull final String dateFormat) {
		return null;
	}

	/**
	 * Convert string to locale date time.
	 *
	 * @param stringDate the string date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public final LocalDate convertStringToLocaleDateTime(@NonNull final String stringDate,
			@NonNull final String dateFormat) {
		return null;
	}

	/**
	 * Convert locale date time to string.
	 *
	 * @param date       the date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public final LocalDate convertLocaleDateTimeToString(@NonNull final LocalDateTime date,
			@NonNull final String dateFormat) {
		return null;
	}
}