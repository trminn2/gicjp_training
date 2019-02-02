package com.gic.ems.web.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class M09_HakenCreateModel extends BaseModel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Company Id */
	private Long companyId;

	/** Name */
	private String dispatchDeptName;

	/** Contract Email */
	private String contractEmail;

	/** Contract Person FirstName */
	private String contractPersonFirstName;

	/** Contract Person LastName */
	private String contractPersonLastName;

	/** Contract Person FirstName Kana */
	private String contractPersonFirstNameKana;

	/** Contract Person LastName Kana */
	private String contractPersonLastNameKana;

	/** Contract Phone */
	private String contractPhone;

	/** Address */
	private String address;

	/** Postal Code */
	private String postalCode;

	/** Dispatch Start Date */
	private LocalDate dispatchStartDate;

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