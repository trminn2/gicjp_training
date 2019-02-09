package com.gic.ems.common.utility;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

import io.micrometer.core.lang.NonNull;

/**
 * The Class MessageUtility.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 9, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.common.utility </BR>
 *        MessageUtility.java </BR>
 */
@Component
public class MessageUtility {

	/** The message source. */
	private MessageSource messageSource;

	/** The locale resolver. */
	private LocaleResolver localeResolver;

	/**
	 * Sets the message source.
	 *
	 * @param messageSource the new message source
	 */
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * Sets the locale resolver.
	 *
	 * @param localeResolver the new locale resolver
	 */
	@Autowired
	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	private Locale getLocale() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (null != requestAttributes) {
			HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
			return this.localeResolver.resolveLocale(httpServletRequest);
		}
		return Locale.US;
	}

	/**
	 * Gets the message.
	 *
	 * @param messageCode the message code
	 * @return the message
	 */
	public String getMessage(@NonNull String messageCode) {
		return this.messageSource.getMessage(messageCode, null, this.getLocale());
	}

	/**
	 * Gets the message.
	 *
	 * @param messageCode      the message code
	 * @param messageParameter the message parameter
	 * @return the message
	 */
	public String getMessage(@NonNull String messageCode, String messageParameter) {
		return this.messageSource.getMessage(messageCode, new String[] { this.getMessage(messageParameter) },
				this.getLocale());
	}
}