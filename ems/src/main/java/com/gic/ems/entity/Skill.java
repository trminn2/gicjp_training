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
 * The Class Skill.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class Skill.
 */
@Getter
@Setter

/**
 * Instantiates a new skill.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Skill extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The description. */
	@Column
	private String description;

	/** The skill name. */
	@Column
	private String skillName;

	/** The type. */
	@Column
	private String type;

	/** The employeeskills. */
	@OneToMany(mappedBy = "skill", fetch = FetchType.LAZY, targetEntity = EmployeeSkill.class, orphanRemoval = false)
	private Collection<EmployeeSkill> employeeskills;

	/**
	 * Instantiates a new skill.
	 *
	 * @param id             the id
	 * @param description    the description
	 * @param skillName      the skill name
	 * @param type           the type
	 * @param employeeskills the employeeskills
	 */
	@Builder
	public Skill(Long id, String description, String skillName, String type, Collection<EmployeeSkill> employeeskills) {
		super(id);
		this.description = description;
		this.skillName = skillName;
		this.type = type;
		this.employeeskills = employeeskills;
	}
}