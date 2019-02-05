package com.gic.ems.web.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "Current Password is required")
	@NotBlank(message = "Current Password is required")
	@NotEmpty(message = "Current Password is required")
	private String currentPassword;

	/** The new password. */
	@NotNull(message = "New Password is required")
	@NotBlank(message = "New Password is required")
	@NotEmpty(message = "New Password is required")
	private String newPassword;

	/** The confirm password. */
	@NotNull(message = "Confirm Password is required")
	@NotBlank(message = "Confirm Password is required")
	@NotEmpty(message = "Confirm Password is required")
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