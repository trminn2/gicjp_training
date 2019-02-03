package com.gic.ems.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Company.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class Company.
 */
@Getter
@Setter

/**
 * Instantiates a new company.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Company extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The company code. */
	@Column(unique = true, nullable = false)
	private String companyCode;

	/** The company name. */
	@Column
	private String companyName;

	/** The contact email. */
	@Column
	private String contactEmail;

	/** The contact person first name. */
	@Column
	private String contactPersonFirstName;

	/** The contact person first name kana. */
	@Column
	private String contactPersonFirstNameKana;

	/** The contact person last name. */
	@Column
	private String contactPersonLastName;

	/** The contact person last name kana. */
	@Column
	private String contactPersonLastNameKana;

	/** The contact phone. */
	@Column
	private String contactPhone;

	/** The contract start date. */
	@Column
	private LocalDate contractStartDate;

	/** The address. */
	@Column
	private String address;

	/** The postal code. */
	@Column
	private String postalCode;

	/** The dispatch departments. */
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, targetEntity = DispatchDepartment.class, orphanRemoval = false)
	private Collection<DispatchDepartment> dispatchDepartments;

	/**
	 * Instantiates a new company.
	 *
	 * @param id                         the id
	 * @param companyCode                the company code
	 * @param companyName                the company name
	 * @param contactEmail               the contact email
	 * @param contactPersonFirstName     the contact person first name
	 * @param contactPersonFirstNameKana the contact person first name kana
	 * @param contactPersonLastName      the contact person last name
	 * @param contactPersonLastNameKana  the contact person last name kana
	 * @param contactPhone               the contact phone
	 * @param contractStartDate          the contract start date
	 * @param address                    the address
	 * @param postalCode                 the postal code
	 * @param dispatchDepartments        the dispatch departments
	 */
	@Builder
	public Company(Long id, String companyCode, String companyName, String contactEmail, String contactPersonFirstName,
			String contactPersonFirstNameKana, String contactPersonLastName, String contactPersonLastNameKana,
			String contactPhone, LocalDate contractStartDate, String address, String postalCode,
			Collection<DispatchDepartment> dispatchDepartments) {
		super(id);
		this.companyCode = companyCode;
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
		this.dispatchDepartments = dispatchDepartments;
	}
}