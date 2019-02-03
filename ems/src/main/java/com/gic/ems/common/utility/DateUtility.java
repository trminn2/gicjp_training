package com.gic.ems.common.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.gic.ems.common.type.DateFormat;

import lombok.NonNull;

/**
 * The Class DateUtility.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 27, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.common.utility </BR>
 *        DateUtility.java </BR>
 */
public final class DateUtility {

	/** The date utils. */
	private volatile static DateUtility dateUtils;

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
	 * Instantiates a new date utility.
	 */
	private DateUtility() {
		super();
	}

	/**
	 * Convert locale date time to string.
	 *
	 * @param localDateTime the local date time
	 * @param dateFormat    the date format
	 * @return String
	 */
	public final String convertLocaleDateTimeToString(@NonNull final LocalDateTime localDateTime,
			@NonNull final DateFormat dateFormat) {
		return localDateTime.format(DateTimeFormatter.ofPattern(dateFormat.getFormat()));
	}

	/**
	 * Convert locale date to string.
	 *
	 * @param localDate  the local date
	 * @param dateFormat the date format
	 * @return String
	 */
	public final String convertLocaleDateToString(@NonNull final LocalDate localDate,
			@NonNull final DateFormat dateFormat) {
		return localDate.format(DateTimeFormatter.ofPattern(dateFormat.getFormat()));
	}

	/**
	 * Convert string to locale date.
	 *
	 * @param stringDate the string date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public final LocalDate convertStringToLocaleDate(@NonNull final String stringDate,
			@NonNull final DateFormat dateFormat) {
		return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(dateFormat.getFormat()));
	}

	/**
	 * Convert string to locale date time.
	 *
	 * @param stringDate the string date
	 * @param dateFormat the date format
	 * @return LocalDate
	 */
	public final LocalDateTime convertStringToLocaleDateTime(@NonNull final String stringDate,
			@NonNull final DateFormat dateFormat) {
		return LocalDateTime.parse(stringDate, DateTimeFormatter.ofPattern(dateFormat.getFormat()));
	}
}