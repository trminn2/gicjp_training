/*
 *
 */
package com.gic.ems.entity;

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
 * The Class EmpGroup.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class EmpGroup.
 */
@Getter
@Setter

/**
 * Instantiates a new emp group.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class EmpGroup extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The description. */
	@Column
	private String description;

	/** The name. */
	@Column
	private String name;

	/** The employees. */
	@OneToMany(mappedBy = "empGroup", fetch = FetchType.LAZY, targetEntity = Employee.class, orphanRemoval = false)
	private Collection<Employee> employees;

	/** The dispatchs. */
	@OneToMany(mappedBy = "empGroup", fetch = FetchType.LAZY, targetEntity = Dispatch.class, orphanRemoval = false)
	private Collection<Dispatch> dispatchs;

	/**
	 * Instantiates a new emp group.
	 *
	 * @param id          the id
	 * @param description the description
	 * @param name        the name
	 * @param employees   the employees
	 * @param dispatchs   the dispatchs
	 */
	@Builder
	public EmpGroup(Long id, String description, String name, Collection<Employee> employees,
			Collection<Dispatch> dispatchs) {
		super(id);
		this.description = description;
		this.name = name;
		this.employees = employees;
		this.dispatchs = dispatchs;
	}
}