package com.gic.ems.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Instantiates a new gender.
 */
@NoArgsConstructor

/**
 * Instantiates a new gender.
 *
 * @param id   the id
 * @param name the name
 */
@AllArgsConstructor
public enum Gender {

	/** The male. */
	MALE(0, "Male"),
	/** The female. */
	FEMALE(1, "Femail");

	/** The id. */
	@Getter
	@Setter
	private int id;

	/** The name. */
	@Getter
	@Setter
	@NonNull
	private String name;
}