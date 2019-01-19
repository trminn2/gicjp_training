package com.gic.ems.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
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
public class DispatchDepartment extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Dispatch department name. */
	@Column
	private String DispatchDepartmentName;

	/** The postal code. */
	@Column
	private String postalCode;

	/** The address. */
	@Column
	private String address;

	/** The company. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Company.class, optional = true)
	@JoinColumn
	private Company company;

	/** The contract email. */
	@Column
	private String contractEmail;

	/** The contract person first name. */
	@Column
	private String contractPersonFirstName;

	/** The contract person first name kana. */
	@Column
	private String contractPersonFirstNameKana;

	/** The contract person last name. */
	@Column
	private String contractPersonLastName;

	/** The contract person last name kana. */
	@Column
	private String contractPersonLastNameKana;

	/** The contract phone. */
	@Column
	private String contractPhone;

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
	 * @param id                          the id
	 * @param dispatchDepartmentName      the dispatch department name
	 * @param postalCode                  the postal code
	 * @param address                     the address
	 * @param company                     the company
	 * @param contractEmail               the contract email
	 * @param contractPersonFirstName     the contract person first name
	 * @param contractPersonFirstNameKana the contract person first name kana
	 * @param contractPersonLastName      the contract person last name
	 * @param contractPersonLastNameKana  the contract person last name kana
	 * @param contractPhone               the contract phone
	 * @param dispatchDepartmentId        the dispatch department id
	 * @param dispatchStartDate           the dispatch start date
	 * @param dispatches                  the dispatches
	 */
	@Builder
	public DispatchDepartment(Long id, String dispatchDepartmentName, String postalCode, String address,
			Company company, String contractEmail, String contractPersonFirstName, String contractPersonFirstNameKana,
			String contractPersonLastName, String contractPersonLastNameKana, String contractPhone,
			String dispatchDepartmentId, LocalDate dispatchStartDate, Collection<Dispatch> dispatches) {
		super(id);
		DispatchDepartmentName = dispatchDepartmentName;
		this.postalCode = postalCode;
		this.address = address;
		this.company = company;
		this.contractEmail = contractEmail;
		this.contractPersonFirstName = contractPersonFirstName;
		this.contractPersonFirstNameKana = contractPersonFirstNameKana;
		this.contractPersonLastName = contractPersonLastName;
		this.contractPersonLastNameKana = contractPersonLastNameKana;
		this.contractPhone = contractPhone;
		this.dispatchDepartmentId = dispatchDepartmentId;
		this.dispatchStartDate = dispatchStartDate;
		this.dispatches = dispatches;
	}
}