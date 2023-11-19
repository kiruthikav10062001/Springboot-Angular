package org.virtusa.spring.exception;

public class DomainNotFoundException extends RuntimeException{
	public DomainNotFoundException(String desc)
	{
		super(desc);
	}

}
