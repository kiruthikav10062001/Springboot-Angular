package org.virtusa.spring.exception;

public class DomainFoundException extends RuntimeException {
	public DomainFoundException(String desc)
	{
		super(desc);
		
	}
}
