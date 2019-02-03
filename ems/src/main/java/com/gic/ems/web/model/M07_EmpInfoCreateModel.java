package com.gic.ems.web.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M07_EmpInfoCreateModel.</BR>
 *
 * @author THETTHETKHINE </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.web.model </BR>
 *        M07_EmpInfoCreateModel.java </BR>
 */

@Getter
@Setter

/**
 * Instantiates a new m 07 emp info create model.
 */
@NoArgsConstructor
public class M07_EmpInfoCreateModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Employee Id. */
	private String employeeId;

	/** First Name. */
	private String firstName;

	/** Last Name. */
	private String lastName;

	/** First Name Kana. */
	private String firstNameKana;

	/** Last Name Kana. */
	private String lastNameKana;

	/** Postal Code. */
	private String postalCode;

	/** Address. */
	private String address;

	/** Gender. */
	private String gender;

	/** Nationality. */
	private String nationality;

	/** Phone. */
	private String phone;

	/** Email. */
	private String email;

	/** Residence Number. */
	private String residenceNo;

	/** Residence Status. */
	private String residenceStatus;

	/** Residence Period. */
	private String residencePeriod;

	/** Passport Type. */
	private String passportType;

	/** Passport Number. */
	private String passportNum;

	/** Passport Country Code. */
	private String passportCountryCode;

	/** Passport Authority. */
	private String passportAuthority;

	/** Bank Account. */
	private String bankAccount;

	/** Insurance Type. */
	private String insuranceType;

	/** Insured Number. */
	private String insuredNum;

	/** Insured Name. */
	private String insurerName;

	/** My Number. */
	private String myNumber;

	/** Start Station. */
	private String startStation;

	/** End Station. */
	private String endStation;

	/** The Way of Thinking. */
	private String wayOfThinking;

	/** Confidence Skill. */
	private String confidenceSkill;

	/** The special. */
	private String speciality;

	/** Group Id. */
	private int groupId;

	/** Band. */
	private int band;

	/** Department Id. */
	private int departmentId;

	/** Certificate Id. */
	private int certificateId;

	/** Birth Date. */
	private Date birthDate;

	/** Hired Date. */
	private Date hiredDate;

	/** Passport Issued Date. */
	private Date passportIssuedDate;

	/** Passport Expired Date. */
	private Date passportExpiredDate;

	/** Insured Qualified Date. */
	private Date insuredQualifiedDate;

	/** Commuter Pass Expired Date. */
	private Date commuterPassExpiredDate;

	/**
	 * Instantiates a new m 07 emp info create model.
	 *
	 * @param id                      the id
	 * @param uuid                    the uuid
	 * @param employeeId              the employee id
	 * @param firstName               the first name
	 * @param lastName                the last name
	 * @param firstNameKana           the first name kana
	 * @param lastNameKana            the last name kana
	 * @param postalCode              the postal code
	 * @param address                 the address
	 * @param gender                  the gender
	 * @param nationality             the nationality
	 * @param phone                   the phone
	 * @param email                   the email
	 * @param residenceNo             the residence no
	 * @param residenceStatus         the residence status
	 * @param residencePeriod         the residence period
	 * @param passportType            the passport type
	 * @param passportNum             the passport num
	 * @param passportCountryCode     the passport country code
	 * @param passportAuthority       the passport authority
	 * @param bankAccount             the bank account
	 * @param insuranceType           the insurance type
	 * @param insuredNum              the insured num
	 * @param insurerName             the insurer name
	 * @param myNumber                the my number
	 * @param startStation            the start station
	 * @param endStation              the end station
	 * @param wayOfThinking           the way of thinking
	 * @param confidenceSkill         the confidence skill
	 * @param speciality              the speciality
	 * @param groupId                 the group id
	 * @param band                    the band
	 * @param departmentId            the department id
	 * @param certificateId           the certificate id
	 * @param birthDate               the birth date
	 * @param hiredDate               the hired date
	 * @param passportIssuedDate      the passport issued date
	 * @param passportExpiredDate     the passport expired date
	 * @param insuredQualifiedDate    the insured qualified date
	 * @param commuterPassExpiredDate the commuter pass expired date
	 */

	/**
	 * Builds the.
	 *
	 * @return M07_EmpInfoCreateModel
	 */
	@Builder
	public M07_EmpInfoCreateModel(Long id, String uuid, String employeeId, String firstName, String lastName,
			String firstNameKana, String lastNameKana, String postalCode, String address, String gender,
			String nationality, String phone, String email, String residenceNo, String residenceStatus,
			String residencePeriod, String passportType, String passportNum, String passportCountryCode,
			String passportAuthority, String bankAccount, String insuranceType, String insuredNum, String insurerName,
			String myNumber, String startStation, String endStation, String wayOfThinking, String confidenceSkill,
			String speciality, int groupId, int band, int departmentId, int certificateId, Date birthDate,
			Date hiredDate, Date passportIssuedDate, Date passportExpiredDate, Date insuredQualifiedDate,
			Date commuterPassExpiredDate) {
		super(id, uuid);
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.firstNameKana = firstNameKana;
		this.lastNameKana = lastNameKana;
		this.postalCode = postalCode;
		this.address = address;
		this.gender = gender;
		this.nationality = nationality;
		this.phone = phone;
		this.email = email;
		this.residenceNo = residenceNo;
		this.residenceStatus = residenceStatus;
		this.residencePeriod = residencePeriod;
		this.passportType = passportType;
		this.passportNum = passportNum;
		this.passportCountryCode = passportCountryCode;
		this.passportAuthority = passportAuthority;
		this.bankAccount = bankAccount;
		this.insuranceType = insuranceType;
		this.insuredNum = insuredNum;
		this.insurerName = insurerName;
		this.myNumber = myNumber;
		this.startStation = startStation;
		this.endStation = endStation;
		this.wayOfThinking = wayOfThinking;
		this.confidenceSkill = confidenceSkill;
		this.speciality = speciality;
		this.groupId = groupId;
		this.band = band;
		this.departmentId = departmentId;
		this.certificateId = certificateId;
		this.birthDate = birthDate;
		this.hiredDate = hiredDate;
		this.passportIssuedDate = passportIssuedDate;
		this.passportExpiredDate = passportExpiredDate;
		this.insuredQualifiedDate = insuredQualifiedDate;
		this.commuterPassExpiredDate = commuterPassExpiredDate;
	}
}