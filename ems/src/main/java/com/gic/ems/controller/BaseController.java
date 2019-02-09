package com.gic.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.gic.ems.common.utility.MessageUtility;

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
	protected String getMessage(String messageCode) {
		return this.messageUtility.getMessage(messageCode);
	}
}