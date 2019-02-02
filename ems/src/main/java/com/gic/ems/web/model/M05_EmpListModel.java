package com.gic.ems.web.model;

import com.gic.ems.common.type.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class EmployeeCreateModel.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Class EmployeeListModel.
 */
@Getter
@Setter

/**
 * Instantiates a new employee list model.
 */
@NoArgsConstructor
public class M05_EmpListModel extends BaseModel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The employee id. */
	private String employeeCode;
	
	/** The first name. */
	private String firstName;
	
	/** The first name kana. */
	private String lastName;
	
	/** The email. */
	private String email;
	
	/** The groupName. */
	private String groupName;
	
	/** The gender. */
	private Gender gender;
	
	/**
	 * Instantiates a new m 04 emp create model.
	 *
	 * @param id            the id
	 * @param uuid          the uuid
	 * @param employeeCode  the employeeCode
	 * @param firstName     the first name
	 * @param lastName      the last name
	 * @param email         the email
	 * @param groupName     the groupName
	 * @param gender        the gender
	 */
	@Builder
	public M05_EmpListModel(Long id, String uuid, String employeeCode, String firstName,
			String lastName,  String email, String groupName, Gender gender) {
		super(id, uuid);
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.groupName = groupName;
		this.gender = gender;
	}

}