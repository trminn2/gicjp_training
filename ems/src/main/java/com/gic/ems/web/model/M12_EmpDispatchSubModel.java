package com.gic.ems.web.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M12_EmpDispatchModel.
 *
 * @author MOEPWINTPHYU Jan 26, 2019 <BR>
 *         The Class M12_EmpDispatchModel.
 */

@Getter
@Setter

/**
 * Instantiates a new m 12 emp dispatch model.
 */
@NoArgsConstructor
public class M12_EmpDispatchSubModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The company id. */
	private String companyId;

	/** The company name. */
	private String companyName;

	/** The dispatch start date. */
	private LocalDate dispatchStartDate;

	/** The contract person first name. */
	private String contractPersonFirstName;

	/** The contract person first name kana. */
	private String contractPersonFirstNameKana;

	/** The contract person last name. */
	private String contractPersonLastName;

	/** The contract person last name kana. */
	private String contractPersonLastNameKana;

	/** The contract phone. */
	private String contractPhone;

	/** The contract email. */
	private String contractEmail;

	/** The postal code. */
	private String postalCode;

	/** The address. */
	private String address;

	/**
	 * Instantiates a new experience.
	 *
	 * @param id                          the id
	 * @param uuid                        the uuid
	 * @param companyId                   the company id
	 * @param companyName                 the company name
	 * @param dispatchStartDate           the dispatch start date
	 * @param dispatchDepartmentName      the dispatch department name
	 * @param contractPersonFirstName     the contract person first name
	 * @param contractPersonLastName      the contract person last name
	 * @param contractPersonFirstNameKana the contract person first name kana
	 * @param contractPersonLastNameKana  the contract person last name kana
	 * @param contractPhone               the contract phone
	 * @param contractEmail               the contract email
	 * @param postalCode                  the postal code
	 * @param address                     the address
	 */
	@Builder
	public M12_EmpDispatchSubModel(Long id, String uuid, String companyId, String companyName, LocalDate dispatchStartDate,
			String contractPersonFirstName, String contractPersonFirstNameKana, String contractPersonLastName,
			String contractPersonLastNameKana, String contractPhone, String contractEmail, String postalCode,
			String address) {
		super(id, uuid);
		this.companyId = companyId;
		this.companyName = companyName;
		this.dispatchStartDate = dispatchStartDate;
	}
}