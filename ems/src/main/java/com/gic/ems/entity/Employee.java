package com.gic.ems.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.gic.ems.common.type.Gender;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Employee.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 5, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.entity </BR>
 *        Employee.java </BR>
 */
@Getter
@Setter

/**
 * Instantiates a new employee.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Employee extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee code. */
	@Column
	private String employeeCode;

	/** The address. */
	@Column
	private String address;

	/** The band. */
	@Column
	private int band;

	/** The bank account. */
	@Column
	private String bankAccount;

	/** The birth date. */
	@Column
	private LocalDate birthDate;

	/** The commuter pass expired date. */
	@Column
	private LocalDate commuterPassExpiredDate;

	/** The confidence skill. */
	@Column
	private String confidenceSkill;

	/** The department. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class, optional = true)
	@JoinColumn
	private Department department;

	/** The end station. */
	@Column
	private String endStation;

	/** The first name. */
	@Column
	private String firstName;

	/** The first name kana. */
	@Column
	private String firstNameKana;

	/** The gender. */
	@Enumerated(EnumType.STRING)
	@Column
	private Gender gender;

	/** The goals. */
	@Column
	private String goals;

	/** The emp group. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = EmpGroup.class)
	@JoinColumn
	private EmpGroup empGroup;

	/** The hired date. */
	@Column
	private LocalDate hiredDate;

	/** The insurance type. */
	@Column
	private String insuranceType;

	/** The insured num. */
	@Column
	private String insuredNum;

	/** The insured qualified date. */
	@Column
	private LocalDate insuredQualifiedDate;

	/** The insurer name. */
	@Column
	private String insurerName;

	/** The insurer num. */
	@Column
	private String insurerNum;

	/** The last name. */
	@Column
	private String lastName;

	/** The last name kana. */
	@Column
	private String lastNameKana;

	/** The my number. */
	@Column
	private String myNumber;

	/** The nationality. */
	@Column
	private String nationality;

	/** The passport authority. */
	@Column
	private String passportAuthority;

	/** The passport country code. */
	@Column
	private String passportCountryCode;

	/** The passport expired date. */
	@Column
	private LocalDate passportExpiredDate;

	/** The passport issued date. */
	@Column
	private LocalDate passportIssuedDate;

	/** The passport num. */
	@Column
	private String passportNum;

	/** The passport type. */
	@Column
	private String passportType;

	/** The phone. */
	@Column
	private String phone;

	/** The postal code. */
	@Column
	private String postalCode;

	/** The residence expire. */
	@Column
	private LocalDate residenceExpire;

	/** The residence no. */
	@Column
	private String residenceNo;

	/** The residence period. */
	@Column
	private short residencePeriod;

	/** The residence status. */
	@Column
	private String residenceStatus;

	/** The speciality. */
	@Column
	private String speciality;

	/** The start station. */
	@Column
	private String startStation;

	/** The way of thinking. */
	@Column
	private String wayOfThinking;

	/** The experiences. */
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Experience.class, orphanRemoval = true)
	private Collection<Experience> experiences;

	/** The employeeskills. */
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = EmployeeSkill.class, orphanRemoval = true)
	private Collection<EmployeeSkill> employeeskills;

	/** The employee certificates. */
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, targetEntity = EmployeeCertificate.class, orphanRemoval = false)
	private Collection<EmployeeCertificate> employeeCertificates;

	/** The user. */
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class, orphanRemoval = true)
	private User user;

	/** The dispatchs. */
	@OneToMany(mappedBy = "employee", targetEntity = Dispatch.class, fetch = FetchType.LAZY, orphanRemoval = false)
	private Collection<Dispatch> dispatchs;

	/**
	 * Instantiates a new employee.
	 *
	 * @param id                      the id
	 * @param employeeCode            the employee code
	 * @param address                 the address
	 * @param band                    the band
	 * @param bankAccount             the bank account
	 * @param birthDate               the birth date
	 * @param commuterPassExpiredDate the commuter pass expired date
	 * @param confidenceSkill         the confidence skill
	 * @param department              the department
	 * @param endStation              the end station
	 * @param firstName               the first name
	 * @param firstNameKana           the first name kana
	 * @param gender                  the gender
	 * @param goals                   the goals
	 * @param empGroup                the emp group
	 * @param hiredDate               the hired date
	 * @param insuranceType           the insurance type
	 * @param insuredNum              the insured num
	 * @param insuredQualifiedDate    the insured qualified date
	 * @param insurerName             the insurer name
	 * @param insurerNum              the insurer num
	 * @param lastName                the last name
	 * @param lastNameKana            the last name kana
	 * @param myNumber                the my number
	 * @param nationality             the nationality
	 * @param passportAuthority       the passport authority
	 * @param passportCountryCode     the passport country code
	 * @param passportExpiredDate     the passport expired date
	 * @param passportIssuedDate      the passport issued date
	 * @param passportNum             the passport num
	 * @param passportType            the passport type
	 * @param phone                   the phone
	 * @param postalCode              the postal code
	 * @param residenceExpire         the residence expire
	 * @param residenceNo             the residence no
	 * @param residencePeriod         the residence period
	 * @param residenceStatus         the residence status
	 * @param speciality              the speciality
	 * @param startStation            the start station
	 * @param wayOfThinking           the way of thinking
	 * @param experiences             the experiences
	 * @param employeeskills          the employeeskills
	 * @param employeeCertificates    the employee certificates
	 * @param user                    the user
	 * @param dispatchs               the dispatchs
	 */

	/**
	 * Builds the.
	 *
	 * @return Employee
	 */
	@Builder
	public Employee(Long id, String employeeCode, String address, int band, String bankAccount, LocalDate birthDate,
			LocalDate commuterPassExpiredDate, String confidenceSkill, Department department, String endStation,
			String firstName, String firstNameKana, Gender gender, String goals, EmpGroup empGroup, LocalDate hiredDate,
			String insuranceType, String insuredNum, LocalDate insuredQualifiedDate, String insurerName,
			String insurerNum, String lastName, String lastNameKana, String myNumber, String nationality,
			String passportAuthority, String passportCountryCode, LocalDate passportExpiredDate,
			LocalDate passportIssuedDate, String passportNum, String passportType, String phone, String postalCode,
			LocalDate residenceExpire, String residenceNo, short residencePeriod, String residenceStatus,
			String speciality, String startStation, String wayOfThinking, Collection<Experience> experiences,
			Collection<EmployeeSkill> employeeskills, Collection<EmployeeCertificate> employeeCertificates, User user,
			Collection<Dispatch> dispatchs) {
		super(id);
		this.employeeCode = employeeCode;
		this.address = address;
		this.band = band;
		this.bankAccount = bankAccount;
		this.birthDate = birthDate;
		this.commuterPassExpiredDate = commuterPassExpiredDate;
		this.confidenceSkill = confidenceSkill;
		this.department = department;
		this.endStation = endStation;
		this.firstName = firstName;
		this.firstNameKana = firstNameKana;
		this.gender = gender;
		this.goals = goals;
		this.empGroup = empGroup;
		this.hiredDate = hiredDate;
		this.insuranceType = insuranceType;
		this.insuredNum = insuredNum;
		this.insuredQualifiedDate = insuredQualifiedDate;
		this.insurerName = insurerName;
		this.insurerNum = insurerNum;
		this.lastName = lastName;
		this.lastNameKana = lastNameKana;
		this.myNumber = myNumber;
		this.nationality = nationality;
		this.passportAuthority = passportAuthority;
		this.passportCountryCode = passportCountryCode;
		this.passportExpiredDate = passportExpiredDate;
		this.passportIssuedDate = passportIssuedDate;
		this.passportNum = passportNum;
		this.passportType = passportType;
		this.phone = phone;
		this.postalCode = postalCode;
		this.residenceExpire = residenceExpire;
		this.residenceNo = residenceNo;
		this.residencePeriod = residencePeriod;
		this.residenceStatus = residenceStatus;
		this.speciality = speciality;
		this.startStation = startStation;
		this.wayOfThinking = wayOfThinking;
		this.experiences = experiences;
		this.employeeskills = employeeskills;
		this.employeeCertificates = employeeCertificates;
		this.user = user;
		this.dispatchs = dispatchs;
	}
}