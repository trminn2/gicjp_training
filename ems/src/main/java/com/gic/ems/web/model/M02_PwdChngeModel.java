package com.gic.ems.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class M02_PasswordUpdateModel.
 *
 * @author GIC-JP Jan 26, 2019 <BR>
 *         The Class M02_PasswordUpdateModel.
 */
@Getter
@Setter

/**
 * Instantiates a new m 02 password update model.
 */
@NoArgsConstructor
public class M02_PwdChngeModel extends BaseModel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The current password. */
	private String currentPassword;

	/** The new password. */
	private String newPassword;

	/** The confirm password. */
	private String confirmPassword;

	/**
	 * Instantiates a new m 02 password update model.
	 *
	 * @param id              the id
	 * @param uuid            the uuid
	 * @param currentPassword the current password
	 * @param newPassword     the new password
	 * @param confirmPassword the confirm password
	 */

	/**
	 * Builds the.
	 *
	 * @return M02_PasswordUpdateModel
	 */
	@Builder
	public M02_PwdChngeModel(Long id, String uuid, String currentPassword, String newPassword, String confirmPassword) {
		super(id, uuid);
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
}