package com.gic.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Dispatch.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class Dispatch.
 */
@Getter
@Setter

/**
 * Instantiates a new dispatch.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Dispatch extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The company. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Company.class, optional = true)
	@JoinColumn
	private Company company;

	/** The dispatch department. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DispatchDepartment.class, optional = true)
	@JoinColumn
	private DispatchDepartment dispatchDepartment;

	/** The dispatch end date. */
	@Column
	private LocalDate dispatchEndDate;

	/** The dispatch start date. */
	@Column
	private LocalDate dispatchStartDate;

	/** The employee. */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class, optional = true)
	@JoinColumn
	private Employee employee;

	/** The emp group. */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class, optional = true)
	@JoinColumn
	private EmpGroup empGroup;

	/** The income. */
	@Column
	private Double income;

	/**
	 * Instantiates a new dispatch.
	 *
	 * @param id                 the id
	 * @param company            the company
	 * @param dispatchDepartment the dispatch department
	 * @param dispatchEndDate    the dispatch end date
	 * @param dispatchStartDate  the dispatch start date
	 * @param employee           the employee
	 * @param empGroup           the emp group
	 * @param income             the income
	 */
	@Builder
	public Dispatch(Long id, Company company, DispatchDepartment dispatchDepartment, LocalDate dispatchEndDate,
			LocalDate dispatchStartDate, Employee employee, EmpGroup empGroup, Double income) {
		super(id);
		this.company = company;
		this.dispatchDepartment = dispatchDepartment;
		this.dispatchEndDate = dispatchEndDate;
		this.dispatchStartDate = dispatchStartDate;
		this.employee = employee;
		this.empGroup = empGroup;
		this.income = income;
	}
}