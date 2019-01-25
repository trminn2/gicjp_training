package com.gic.ems.web.model;

import com.gic.ems.common.type.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class EmployeeCreateModel.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class EmployeeCreateModel.
 */
@Getter
@Setter

/**
 * Instantiates a new employee create model.
 */
@NoArgsConstructor
public class M04_EmpCreateModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee id. */
	private String employeeId;

	/** The first name. */
	private String firstName;

	/** The first name kana. */
	private String firstNameKana;

	/** The last name. */
	private String lastName;

	/** The last name kana. */
	private String lastNameKana;

	/** The gender. */
	private Gender gender;

	/** The email. */
	private String email;

	/**
	 * Instantiates a new m 04 emp create model.
	 *
	 * @param id            the id
	 * @param uuid          the uuid
	 * @param employeeId    the employee id
	 * @param firstName     the first name
	 * @param firstNameKana the first name kana
	 * @param lastName      the last name
	 * @param lastNameKana  the last name kana
	 * @param gender        the gender
	 * @param email         the email
	 */
	@Builder
	public M04_EmpCreateModel(Long id, String uuid, String employeeId, String firstName, String firstNameKana,
			String lastName, String lastNameKana, Gender gender, String email) {
		super(id, uuid);
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.firstNameKana = firstNameKana;
		this.lastName = lastName;
		this.lastNameKana = lastNameKana;
		this.gender = gender;
		this.email = email;
	}
}