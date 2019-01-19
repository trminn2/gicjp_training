package com.gic.ems.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Department.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class Department.
 */
@Getter
@Setter

/**
 * Instantiates a new department.
 */
@NoArgsConstructor
@Entity
public class Department extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	@Column
	private String name;

	/** The description. */
	@Column
	private String description;

	/** The employees. */
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, orphanRemoval = false)
	private Collection<Employee> employees;

	/**
	 * Instantiates a new department.
	 *
	 * @param id          the id
	 * @param name        the name
	 * @param description the description
	 * @param employees   the employees
	 */
	@Builder
	public Department(Long id, String name, String description, Collection<Employee> employees) {
		super(id);
		this.name = name;
		this.description = description;
		this.employees = employees;
	}
}