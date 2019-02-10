package com.gic.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gic.ems.common.constant.Constant;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.common.utility.MessageUtility;

import lombok.NonNull;

/**
 * The Class BaseController.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 9, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.controller </BR>
 *        BaseController.java </BR>
 */
@Controller
public abstract class BaseController {

	/** The message utility. */
	private MessageUtility messageUtility;

	/**
	 * Sets the message utility.
	 *
	 * @param messageUtility the new message utility
	 */
	@Autowired
	public void setMessageUtility(MessageUtility messageUtility) {
		this.messageUtility = messageUtility;
	}

	/**
	 * Gets the message.
	 *
	 * @param messageCode the message code
	 * @return the message
	 */
	protected String getMessage(@NonNull String messageCode) {
		return this.messageUtility.getMessage(messageCode);
	}

	/**
	 * Redirect URL.
	 *
	 * @param url the url
	 * @return String
	 */
	protected String redirectURL(@NonNull String url) {
		return new StringBuilder(ControllerConstant.REDIRECT).append(url).toString();
	}

	/**
	 * Redirect URL.
	 *
	 * @param param the param
	 * @param url   the url
	 * @return String
	 */
	protected String redirectURL(@NonNull String param, @NonNull String url) {
		return new StringBuilder(ControllerConstant.REDIRECT).append(param).append(Constant.SLASH).append(url)
				.toString();
	}
}