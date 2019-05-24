package com.crunchify.exception;

public class SpringCrunchifyException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String returnMessage = null;

	  public SpringCrunchifyException() {
	    super();

	  }

	  public SpringCrunchifyException(Throwable excp) {
	    super(excp);

	  }

	  public SpringCrunchifyException(Throwable excp, String message) {
	    super(excp);
	    this.returnMessage = message;

	  }

	  public SpringCrunchifyException(String message) {
	    super(message);
	    this.returnMessage = message;

	  }

	  @Override
	  public String getMessage() {
	    return returnMessage;

	  }

	  public String toString() {
	    return returnMessage;

	  }

}