/*
 * 作成日 : 2019/01/26
 * 作成者 : テッ　テッ　カイン
 * 画面名 : M09_派遣先情報登録画面
 */
package com.gic.ems.web.model;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class M09_HakenCreateModel extends BaseModel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Dispatch Department Id */
	private String dispatchDepartmentId;
	
	/** Company Id */
	private String companyId;
	
	/** Name */
	private String name;
	
	/** Contract Email */
	private String contractEmail;
	
	/** Contract Person FirstName */
	private String contractPersonFirstName;
	
	/** Contract Person LastName  */
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
	private String dispatchStartDate;

	/**
	 * @param id
	 * @param uuid
	 * @param dispatchDepartmentId
	 * @param companyId
	 * @param name
	 * @param contractEmail
	 * @param contractPersonFirstName
	 * @param contractPersonLastName
	 * @param contractPersonFirstNameKana
	 * @param contractPersonLastNameKana
	 * @param contractPhone
	 * @param address
	 * @param postalCode
	 * @param dispatchStartDate
	 */
	@Builder
	public M09_HakenCreateModel(Long id, String uuid, String dispatchDepartmentId, String companyId, String name,
			String contractEmail, String contractPersonFirstName, String contractPersonLastName,
			String contractPersonFirstNameKana, String contractPersonLastNameKana, String contractPhone, String address,
			String postalCode, String dispatchStartDate) {
		super(id, uuid);
		this.dispatchDepartmentId = dispatchDepartmentId;
		this.companyId = companyId;
		this.name = name;
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