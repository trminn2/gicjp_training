package com.gic.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gic.ems.common.type.Role;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class User.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class User.
 */
@Getter
@Setter
/**
 * Instantiates a new user.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false, doNotUseGetters = true, onlyExplicitlyIncluded = true)
public class User extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee. */
	@NotNull
	@MapsId
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Employee.class, optional = true)
	private Employee employee;

	/** The password. */
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(nullable = false)
	private String password;

	/** The email. */
	@NotNull
	@NotEmpty
	@NotBlank
	@Column(unique = true, nullable = false)
	private String email;

	/** The role. */
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;

	/**
	 * Instantiates a new user.
	 *
	 * @param id       the id
	 * @param employee the employee
	 * @param password the password
	 * @param email    the email
	 * @param role     the role
	 */
	@Builder
	public User(Long id, Employee employee, String password, String email, Role role) {
		super(id);
		this.employee = employee;
		this.password = password;
		this.email = email;
		this.role = role;
	}
}