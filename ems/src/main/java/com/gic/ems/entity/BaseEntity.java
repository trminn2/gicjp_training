/**
 * Self.
 *
 * @return B
 */
package com.gic.ems.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;

import com.gic.ems.common.constant.Constant;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.common.utility.UserUtility;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * The Class BaseEntity.
 *
 * @author KYIMINHAN Jan 4, 2019 <BR>
 *         The Class BaseEntity.
 */
@Getter
@Setter

/**
 * Update date.
 *
 * @param updateDate the update date
 * @return B
 */
@SuperBuilder
@Component
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The uuid. */
	@Column(insertable = true, nullable = false, updatable = true)
	private String uuid;

	/** The create user. */
	@Column(insertable = true, nullable = false, updatable = false)
	private String createUser;

	/** The create date. */
	@Column(insertable = true, nullable = false, updatable = false)
	private LocalDateTime createDate;

	/** The update user. */
	@Column(insertable = true, nullable = false, updatable = true)
	private String updateUser;

	/** The update date. */
	@Column(insertable = true, nullable = false, updatable = true)
	private LocalDateTime updateDate;

	/** The delete flag. */
	@Enumerated(EnumType.STRING)
	@Column
	private DeleteFlag deleteFlag;

	/**
	 * Instantiates a new base entity.
	 */
	public BaseEntity() {
		super();
		this.init();
	}

	/**
	 * Instantiates a new base entity.
	 *
	 * @param id the id
	 */
	public BaseEntity(Long id) {
		super();
		if (null != id && 0 < id.longValue()) {
			this.id = id;
		}
		this.init();
	}

	/**
	 * Initialize the default setting.
	 */
	public void init() {
		this.deleteFlag = DeleteFlag.ACTIVE;
		this.createDate = LocalDateTime.now();
		this.updateDate = LocalDateTime.now();
		this.createUser = UserUtility.getLoginUserName();
		this.updateUser = UserUtility.getLoginUserName();
		this.uuid = UUID.randomUUID().toString().replace(Constant.HYPHEN, Constant.EMPTY_STRING);
	}

	/**
	 * Removes the object.
	 */
	public void remove() {
		this.init();
		this.deleteFlag = DeleteFlag.DELETED;
	}
}