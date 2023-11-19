package org.virtusa.spring.exception;

public class InstituteNotFoundException extends RuntimeException{
	public InstituteNotFoundException(String desc)
	{
		super(desc);
	}

}
