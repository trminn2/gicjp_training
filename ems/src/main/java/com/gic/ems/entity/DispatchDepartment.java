package com.gic.ems.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class DispatchDepartment.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class DispatchDepartment.
 */
@Getter
@Setter

/**
 * Instantiates a new dispatch department.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class DispatchDepartment extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Dispatch department name. */
	@Column
	private String dispatchDepartmentName;

	/** The postal code. */
	@Column
	private String postalCode;

	/** The address. */
	@Column
	private String address;

	/** The company. */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Company.class, optional = true)
	@JoinColumn
	private Company company;

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

	/** The dispatch department id. */
	@Column
	private String dispatchDepartmentId;

	/** The dispatch start date. */
	@Column
	private LocalDate dispatchStartDate;

	/** The dispatches. */
	@OneToMany(mappedBy = "dispatchDepartment", targetEntity = Dispatch.class, fetch = FetchType.LAZY, orphanRemoval = false)
	private Collection<Dispatch> dispatches;

	/**
	 * Instantiates a new dispatch department.
	 *
	 * @param id                         the id
	 * @param dispatchDepartmentName     the dispatch department name
	 * @param postalCode                 the postal code
	 * @param address                    the address
	 * @param company                    the company
	 * @param contactEmail               the contact email
	 * @param contactPersonFirstName     the contact person first name
	 * @param contactPersonFirstNameKana the contact person first name kana
	 * @param contactPersonLastName      the contact person last name
	 * @param contactPersonLastNameKana  the contact person last name kana
	 * @param contactPhone               the contact phone
	 * @param dispatchDepartmentId       the dispatch department id
	 * @param dispatchStartDate          the dispatch start date
	 * @param dispatches                 the dispatches
	 */
	@Builder
	public DispatchDepartment(Long id, String dispatchDepartmentName, String postalCode, String address,
			Company company, String contactEmail, String contactPersonFirstName, String contactPersonFirstNameKana,
			String contactPersonLastName, String contactPersonLastNameKana, String contactPhone,
			String dispatchDepartmentId, LocalDate dispatchStartDate, Collection<Dispatch> dispatches) {
		super(id);
		this.dispatchDepartmentName = dispatchDepartmentName;
		this.postalCode = postalCode;
		this.address = address;
		this.company = company;
		this.contactEmail = contactEmail;
		this.contactPersonFirstName = contactPersonFirstName;
		this.contactPersonFirstNameKana = contactPersonFirstNameKana;
		this.contactPersonLastName = contactPersonLastName;
		this.contactPersonLastNameKana = contactPersonLastNameKana;
		this.contactPhone = contactPhone;
		this.dispatchDepartmentId = dispatchDepartmentId;
		this.dispatchStartDate = dispatchStartDate;
		this.dispatches = dispatches;
	}
}