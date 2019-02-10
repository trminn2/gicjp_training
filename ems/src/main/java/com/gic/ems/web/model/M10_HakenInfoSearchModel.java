package com.gic.ems.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M10_HakenInfoSearchModel.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.web.model </BR>
 *        M10_HakenInfoSearchModel.java </BR>
 */
@Getter
@Setter

/**
 * Instantiates a new m 10 haken info search model.
 */
@NoArgsConstructor
public class M10_HakenInfoSearchModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The company name. */
	private String companyName;

	/** The destination name. */
	private String destinationName;

	/** The name. */
	private String name;

	/** The start date. */
	private String startDate;

	/** The end date. */
	private String endDate;

	/**
	 * Instantiates a new m 10 haken info search model.
	 *
	 * @param id              the id
	 * @param uuid            the uuid
	 * @param companyName     the company name
	 * @param destinationName the destination name
	 * @param name            the name
	 * @param startDate       the start date
	 * @param endDate         the end date
	 */
	@Builder
	public M10_HakenInfoSearchModel(Long id, String uuid, String companyName, String destinationName, String name,
			String startDate, String endDate) {
		super(id, uuid);
		this.companyName = companyName;
		this.destinationName = destinationName;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}