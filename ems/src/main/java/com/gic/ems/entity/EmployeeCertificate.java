package com.gic.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class EmployeeCertificate.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class EmployeeCertificate.
 */
@Getter
@Setter

/**
 * Instantiates a new employee certificate.
 */
@NoArgsConstructor
@Entity
public class EmployeeCertificate extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The certificate. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Certificate.class, optional = true)
	@JoinColumn
	private Certificate certificate;

	/** The employee. */
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, optional = true)
	@JoinColumn
	private Employee employee;

	/** The acquired date. */
	@Column
	private LocalDate acquiredDate;

	/** The expire date. */
	@Column
	private LocalDate expireDate;

	/**
	 * Instantiates a new employee certificate.
	 *
	 * @param id           the id
	 * @param certificate  the certificate
	 * @param employee     the employee
	 * @param acquiredDate the acquired date
	 * @param expireDate   the expire date
	 */
	@Builder
	public EmployeeCertificate(Long id, Certificate certificate, Employee employee, LocalDate acquiredDate,
			LocalDate expireDate) {
		super(id);
		this.certificate = certificate;
		this.employee = employee;
		this.acquiredDate = acquiredDate;
		this.expireDate = expireDate;
	}
}