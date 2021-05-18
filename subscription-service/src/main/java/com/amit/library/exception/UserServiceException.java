package com.amit.library.exception;

public class UserServiceException extends RuntimeException{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 4715393260116131741L;

	

	public UserServiceException(String message)
	{
		super(message);
	}
}