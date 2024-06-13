package com.example.exercise.cmn;

import java.text.MessageFormat;

/**
 * The Class ApplicationException.
 */
public class ApplicationException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7306999265277221160L;
	
	/** The err code. */
	private String errCode;
	
	/** The err msg. */
	private String errMsg;
	
	/** The err params. */
	private Object[] errParams;

	/**
	 * Instantiates a new application exception.
	 *
	 * @param errCode the err code
	 */
	public ApplicationException(String errCode) {
		super(errCode);
		this.errCode = errCode;
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param e the e
	 */
	public ApplicationException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param errCode the err code
	 * @param cause the cause
	 */
	public ApplicationException(String errCode, Throwable cause) {
		super(errCode, cause);
		this.errCode = errCode;
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param errCode the err code
	 * @param errMsg the err msg
	 */
	public ApplicationException(String errCode, String errMsg) {
		super(errCode);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param errCode the err code
	 * @param errMsg the err msg
	 * @param cause the cause
	 */
	public ApplicationException(String errCode, String errMsg, Throwable cause) {
		super(errCode, cause);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param errCode the err code
	 * @param errMsg the err msg
	 * @param errParams the err params
	 */
	public ApplicationException(String errCode, String errMsg, String... errParams) {
		super(errCode);
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.errParams = errParams;
	}

	/**
	 * Instantiates a new application exception.
	 *
	 * @param cause the cause
	 * @param errCode the err code
	 * @param errMsg the err msg
	 * @param errParams the err params
	 */
	public ApplicationException(Throwable cause, String errCode, String errMsg, String... errParams) {
		super(errCode, cause);
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.errParams = errParams;
	}

	/**
	 * Gets the err code.
	 *
	 * @return the err code
	 */
	public String getErrCode() {
		return this.errCode;
	}

	/**
	 * Sets the err code.
	 *
	 * @param errCode the new err code
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * Gets the err msg.
	 *
	 * @return the err msg
	 */
	public String getErrMsg() {
		if (this.errParams != null && this.errParams.length > 0) {
			this.errMsg = MessageFormat.format(this.errMsg, this.errParams);
		}

		return this.errMsg;
	}

	/**
	 * Sets the err msg.
	 *
	 * @param errMsg the new err msg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
