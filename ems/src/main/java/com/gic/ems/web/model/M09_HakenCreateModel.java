package com.gic.ems.web.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M09_HakenCreateModel.</BR>
 *
 * @author THETTHETKHINE </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.web.model </BR>
 *        M09_HakenCreateModel.java </BR>
 */
@Getter
@Setter

/**
 * Instantiates a new m 09 haken create model.
 */
@NoArgsConstructor
public class M09_HakenCreateModel extends BaseModel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Company Id. */
	private Long companyId;

	/** Name. */
	private String dispatchDeptName;

	/** Contract Email. */
	private String contractEmail;

	/** Contract Person FirstName. */
	private String contractPersonFirstName;

	/** Contract Person LastName. */
	private String contractPersonLastName;

	/** Contract Person FirstName Kana. */
	private String contractPersonFirstNameKana;

	/** Contract Person LastName Kana. */
	private String contractPersonLastNameKana;

	/** Contract Phone. */
	private String contractPhone;

	/** Address. */
	private String address;

	/** Postal Code. */
	private String postalCode;

	/** Dispatch Start Date. */
	private LocalDate dispatchStartDate;

	/**
	 * Instantiates a new m 09 haken create model.
	 *
	 * @param id                          the id
	 * @param uuid                        the uuid
	 * @param companyId                   the company id
	 * @param dispatchDeptName            the dispatch dept name
	 * @param contractEmail               the contract email
	 * @param contractPersonFirstName     the contract person first name
	 * @param contractPersonLastName      the contract person last name
	 * @param contractPersonFirstNameKana the contract person first name kana
	 * @param contractPersonLastNameKana  the contract person last name kana
	 * @param contractPhone               the contract phone
	 * @param address                     the address
	 * @param postalCode                  the postal code
	 * @param dispatchStartDate           the dispatch start date
	 */

	/**
	 * Builds the.
	 *
	 * @return M09_HakenCreateModel
	 */
	@Builder
	public M09_HakenCreateModel(Long id, String uuid, Long companyId, String dispatchDeptName, String contractEmail,
			String contractPersonFirstName, String contractPersonLastName, String contractPersonFirstNameKana,
			String contractPersonLastNameKana, String contractPhone, String address, String postalCode,
			LocalDate dispatchStartDate) {
		super(id, uuid);
		this.companyId = companyId;
		this.dispatchDeptName = dispatchDeptName;
		this.contractEmail = contractEmail;
		this.contractPersonFirstName = contractPersonFirstName;
		this.contractPersonLastName = contractPersonLastName;
		this.contractPersonFirstNameKana = contractPersonFirstNameKana;
		this.contractPersonLastNameKana = contractPersonLastNameKana;
		this.contractPhone = contractPhone;
		this.address = address;
		this.postalCode = postalCode;
		this.dispatchStartDate = dispatchStartDate;
	}
}