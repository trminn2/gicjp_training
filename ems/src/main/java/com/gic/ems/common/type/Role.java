package com.gic.ems.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Instantiates a new role.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 * The Enum Role.
 */

/**
 * Instantiates a new role.
 */
@NoArgsConstructor

/**
 * Instantiates a new role.
 *
 * @param id   the id
 * @param role the role
 */
@AllArgsConstructor
public enum Role {

	/** The user. */
	USER(0, "User"),
	/** The leader. */
	LEADER(0, "Leader"),
	/** The manager. */
	MANAGER(0, "Manager"),
	/** The admin. */
	ADMIN(0, "Admin");

	/** The id. */
	@Getter
	@Setter
	private int id;

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	@Getter
	@Setter
	@NonNull
	private String role;
}