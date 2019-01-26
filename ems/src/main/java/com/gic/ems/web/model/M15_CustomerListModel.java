/*
   * 作成日 : 2019/01/26
   * 作成者 : 
   * 画面名 : M15_お客様一覧画面
 */

package com.gic.ems.web.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class M15_CustomerListModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Name */
	private String name;

	/** Id */
	private String companyId;

	/** Contract Start Date */
	private LocalDate contractStartDate;

	/** Address */
	private String address;

	/** Postal Code */
	private String postalCode;

	/** Contract Person FirstName */
	private String contactPersonFirstName;

	/** Contract Person LastName */
	private String contactPersonLastName;

	/** Contract Person FirstName Kana */
	private String contactPersonFirstNameKana;

	/** Contract Person LastName Kana */
	private String contactPersonLastNameKana;

	/** Contract Email */
	private String contactEmail;

	/** Contact Phone */
	private String contactPhone;

	/**
	 * @param id
	 * @param uuid
	 * @param name
	 * @param companyId
	 * @param contractStartDate
	 * @param address
	 * @param postalCode
	 * @param contactPersonFirstName
	 * @param contactPersonLastName
	 * @param contactPersonFirstNameKana
	 * @param contactPersonLastNameKana
	 * @param contactEmail
	 * @param contactPhone
	 */
	@Builder
	public M15_CustomerListModel(Long id, String uuid, String name, String companyId, LocalDate contractStartDate,
			String address, String postalCode, String contactPersonFirstName, String contactPersonLastName,
			String contactPersonFirstNameKana, String contactPersonLastNameKana, String contactEmail,
			String contactPhone) {
		super(id, uuid);
		this.name = name;
		this.companyId = companyId;
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