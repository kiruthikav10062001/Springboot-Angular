package org.virtusa.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CourseExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public long id;
	public CourseExistsException(String message) {
		super(message);
	}

	public CourseExistsException(String message, long studentId) {
		super(message);
		this.id=studentId;
		
	}
}