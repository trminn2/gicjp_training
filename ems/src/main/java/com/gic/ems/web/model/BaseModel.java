/**
 * Self.
 *
 * @return B
 */
package com.gic.ems.web.model;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * The Class BaseModel.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class BaseModel.
 */
@Getter
@Setter

/**
 * Uuid.
 *
 * @param uuid the uuid
 * @return B
 */
@SuperBuilder

/**
 * Instantiates a new base model.
 */
@NoArgsConstructor
public abstract class BaseModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The uuid. */
	private String uuid;

	/**
	 * Instantiates a new base model.
	 *
	 * @param id the id
	 */
	public BaseModel(Long id, String uuid) {
		super();
		if (null != id && 0 < id.longValue()) {
			this.id = id;
		}
		if (StringUtils.isNotBlank(uuid)) {
			this.uuid = uuid;
		}
	}
}