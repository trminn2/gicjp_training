package com.gic.ems.entity;

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
 * The Class EmployeeSkill.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class EmployeeSkill.
 */
@Getter
@Setter

/**
 * Instantiates a new employee skill.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class EmployeeSkill extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, optional = true)
	@JoinColumn
	private Employee employee;

	/** The level code. */
	@Column
	private int levelCode;

	/** The skill. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Skill.class, optional = true)
	@JoinColumn
	private Skill skill;

	/**
	 * Instantiates a new employee skill.
	 *
	 * @param id        the id
	 * @param employee  the employee
	 * @param levelCode the level code
	 * @param skill     the skill
	 */
	@Builder
	public EmployeeSkill(Long id, Employee employee, int levelCode, Skill skill) {
		super(id);
		this.employee = employee;
		this.levelCode = levelCode;
		this.skill = skill;
	}
}