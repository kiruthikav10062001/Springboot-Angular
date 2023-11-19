package org.virtusa.spring.exception;

public class CourseFoundException extends RuntimeException {
	public CourseFoundException(String desc)
	{
		super(desc);
	}

}
