package com.gic.ems.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M10_HakenInfoSearchResultModel.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.web.model </BR>
 *        M10_HakenInfoSearchResultModel.java </BR>
 */
@Getter
@Setter

/**
 * Instantiates a new m 10 haken info search result model.
 */
@NoArgsConstructor
public class M10_HakenInfoSearchResultModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The destination name. */
	private String destinationName;

	/** The company name. */
	private String companyName;

	/** The kanji name. */
	private String kanjiName;

	/** The kana name. */
	private String kanaName;

	/** The phone. */
	private String phone;

	/** The email. */
	private String email;

	/** The address. */
	private String address;

	/**
	 * Instantiates a new m 10 haken info search result model.
	 *
	 * @param id              the id
	 * @param uuid            the uuid
	 * @param destinationName the destination name
	 * @param companyName     the company name
	 * @param kanjiName       the kanji name
	 * @param kanaName        the kana name
	 * @param phone           the phone
	 * @param email           the email
	 * @param address         the address
	 */

	/**
	 * Builds the.
	 *
	 * @return M10_HakenInfoSearchResultModel
	 */
	@Builder
	public M10_HakenInfoSearchResultModel(Long id, String uuid, String destinationName, String companyName,
			String kanjiName, String kanaName, String phone, String email, String address) {
		super(id, uuid);
		this.destinationName = destinationName;
		this.companyName = companyName;
		this.kanjiName = kanjiName;
		this.kanaName = kanaName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
}