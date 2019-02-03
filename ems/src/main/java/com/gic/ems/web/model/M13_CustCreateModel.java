package com.gic.ems.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class CustomerCreateModel.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Class CustomerCreateModel.
 */
@Getter
@Setter

/**
 * Instantiates a new employee create model.
 */
@NoArgsConstructor
public class M13_CustCreateModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The companyId id. */
	private String companyId;

	/** The companyName. */
	private String companyName;

	/** The contactEmail. */
	private String contactEmail;

	/** The contactPersonFirstName. */
	private String contactPersonFirstName;

	/** The contactPersonFirstNameKana. */
	private String contactPersonFirstNameKana;

	/** The contactPersonLastName. */
	private String contactPersonLastName;

	/** The contactPersonLastName. */
	private String contactPersonLastNameKana;

	/** The contactPhone. */
	private String contactPhone;

	/** The contractStartDate. */
	private String contractStartDate;

	/** The address. */
	private String address;

	/** The postalCode. */
	private String postalCode;

	/**
	 * Instantiates a new m 05 cust create model.
	 *
	 * @param id                         the id
	 * @param uuid                       the uuid
	 * @param companyId                  the companyId
	 * @param companyName                the companyName
	 * @param contactEmail               the contactEmail
	 * @param contactPersonFirstName     the contactPersonFirstName
	 * @param contactPersonFirstNameKana the contactPersonFirstNameKana
	 * @param contactPersonLastName      the contactPersonLastName
	 * @param contactPersonLastNameKana  the contactPersonLastNameKana
	 * @param contactPhone               the contactPhone
	 * @param contractStartDate          the contractStartDate
	 * @param address                    the address
	 * @param postalCode                 the postalCode
	 */
	@Builder
	public M13_CustCreateModel(Long id, String uuid, String companyId, String companyName, String contactEmail,
			String contactPersonFirstName, String contactPersonFirstNameKana, String contactPersonLastName,
			String contactPersonLastNameKana, String contactPhone, String contractStartDate, String address,
			String postalCode) {
		super(id, uuid);
		this.companyId = companyId;
		this.companyName = companyName;
		this.contactEmail = contactEmail;
		this.contactPersonFirstName = contactPersonFirstName;
		this.contactPersonFirstNameKana = contactPersonFirstNameKana;
		this.contactPersonLastName = contactPersonLastName;
		this.contactPersonLastNameKana = contactPersonLastNameKana;
		this.contactPhone = contactPhone;
		this.contractStartDate = contractStartDate;
		this.address = address;
		this.postalCode = postalCode;
	}
}