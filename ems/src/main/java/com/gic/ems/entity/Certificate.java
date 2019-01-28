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
 * The Class Certificate.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class Certificate.
 */
@Getter
@Setter

/**
 * Instantiates a new certificate.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class Certificate extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The score. */
	@Column
	private int score;

	/** The name. */
	@Column
	private String name;

	/** The type. */
	@Column
	private String type;

	/** The level. */
	@Column
	private String level;

	/** The description. */
	@Column
	private String description;

	/** The validity year. */
	@Column
	private LocalDate validityYear;

	/** The employee certificates. */
	@OneToMany(mappedBy = "certificate", targetEntity = EmployeeCertificate.class, fetch = FetchType.EAGER, orphanRemoval = false)
	private Collection<EmployeeCertificate> employeeCertificates;

	/**
	 * Instantiates a new certificate.
	 *
	 * @param id                   the id
	 * @param score                the score
	 * @param name                 the name
	 * @param type                 the type
	 * @param level                the level
	 * @param description          the description
	 * @param validityYear         the validity year
	 * @param employeeCertificates the employee certificates
	 */
	@Builder
	public Certificate(Long id, int score, String name, String type, String level, String description,
			LocalDate validityYear, Collection<EmployeeCertificate> employeeCertificates) {
		super(id);
		this.score = score;
		this.name = name;
		this.type = type;
		this.level = level;
		this.description = description;
		this.validityYear = validityYear;
		this.employeeCertificates = employeeCertificates;
	}
}