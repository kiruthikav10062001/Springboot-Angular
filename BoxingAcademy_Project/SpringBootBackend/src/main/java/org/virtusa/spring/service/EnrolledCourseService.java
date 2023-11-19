package org.virtusa.spring.service;

import java.util.Set;
import org.virtusa.spring.entity.EnrolledCourses;
import org.virtusa.spring.exception.CourseExistsException;

import org.virtusa.spring.entity.EnrolledCourses;
import org.virtusa.spring.entity.Student;

public interface EnrolledCourseService  {
	public EnrolledCourses addEnrolledCourse(EnrolledCourses enrolledCourse); 
	
	public EnrolledCourses updateEnrolledCourse(EnrolledCourses enrolledCourse);

	public Set<EnrolledCourses> getEnrolledCourses();

	public EnrolledCourses getEnrolledCourse(Long enrolledId);

	public void deleteEnrolledCourse(Long enrolledId);
	
	public Set<EnrolledCourses> getCourseofStudent(Student student);
}
