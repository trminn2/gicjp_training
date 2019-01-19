package com.gic.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Experience.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class Experience.
 */
@Getter
@Setter

/**
 * Instantiates a new experience.
 */
@NoArgsConstructor
@Entity
public class Experience extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee. */
	@ManyToOne
	@JoinColumn
	private Employee employee;

	/** The job role. */
	@Column
	private String jobRole;

	/** The num of member. */
	@Column
	private int numOfMember;

	/** The position. */
	@Column
	private String position;

	/** The project name. */
	@Column
	private String projectName;

	/** The responsibilities. */
	@Column
	private String responsibilities;

	/** The start date. */
	@Column
	private LocalDate startDate;

	/** The end date. */
	@Column
	private LocalDate endDate;

	/** The technologies. */
	@Column
	private String technologies;

	/**
	 * Instantiates a new experience.
	 *
	 * @param id               the id
	 * @param employee         the employee
	 * @param jobRole          the job role
	 * @param numOfMember      the num of member
	 * @param position         the position
	 * @param projectName      the project name
	 * @param responsibilities the responsibilities
	 * @param startDate        the start date
	 * @param endDate          the end date
	 * @param technologies     the technologies
	 */
	@Builder
	public Experience(Long id, Employee employee, String jobRole, int numOfMember, String position, String projectName,
			String responsibilities, LocalDate startDate, LocalDate endDate, String technologies) {
		super(id);
		this.employee = employee;
		this.jobRole = jobRole;
		this.numOfMember = numOfMember;
		this.position = position;
		this.projectName = projectName;
		this.responsibilities = responsibilities;
		this.startDate = startDate;
		this.endDate = endDate;
		this.technologies = technologies;
	}
}