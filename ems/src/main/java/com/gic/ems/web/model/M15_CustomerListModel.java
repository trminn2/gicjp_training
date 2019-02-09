package com.gic.ems.web.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M15_CustomerListModel.</BR>
 *
 * @author THAEMYATNOELWIN </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.web.model </BR>
 *        M15_CustomerListModel.java </BR>
 */
@Getter
@Setter

/**
 * Instantiates a new m 15 customer list model.
 */
@NoArgsConstructor
public class M15_CustomerListModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Company Code. */
	private String companyCode;

	/** Company Name. */
	private String companyName;

	/** Contract Start Date. */
	private LocalDate contractStartDate;

	/** Address. */
	private String address;

	/** Postal Code. */
	private String postalCode;

	/** Contract Person FirstName. */
	private String contactPersonFirstName;

	/** Contract Person LastName. */
	private String contactPersonLastName;

	/** Contract Person FirstName Kana. */
	private String contactPersonFirstNameKana;

	/** Contract Person LastName Kana. */
	private String contactPersonLastNameKana;

	/** Contract Email. */
	private String contactEmail;

	/** Contact Phone. */
	private String contactPhone;

	/**
	 * Instantiates a new m 15 customer list model.
	 *
	 * @param id                         the id
	 * @param uuid                       the uuid
	 * @param companyId                  the company id
	 * @param companyName                the company name
	 * @param contractStartDate          the contract start date
	 * @param address                    the address
	 * @param postalCode                 the postal code
	 * @param contactPersonFirstName     the contact person first name
	 * @param contactPersonLastName      the contact person last name
	 * @param contactPersonFirstNameKana the contact person first name kana
	 * @param contactPersonLastNameKana  the contact person last name kana
	 * @param contactEmail               the contact email
	 * @param contactPhone               the contact phone
	 */

	/**
	 * Builds the.
	 *
	 * @return M15_CustomerListModel
	 */
	@Builder
	public M15_CustomerListModel(Long id, String uuid, String companyCode, String companyName,
			LocalDate contractStartDate, String address, String postalCode, String contactPersonFirstName,
			String contactPersonLastName, String contactPersonFirstNameKana, String contactPersonLastNameKana,
			String contactEmail, String contactPhone) {
		super(id, uuid);
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.contractStartDate = contractStartDate;
		this.address = address;
		this.postalCode = postalCode;
		this.contactPersonFirstName = contactPersonFirstName;
		this.contactPersonLastName = contactPersonLastName;
		this.contactPersonFirstNameKana = contactPersonFirstNameKana;
		this.contactPersonLastNameKana = contactPersonLastNameKana;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}
}