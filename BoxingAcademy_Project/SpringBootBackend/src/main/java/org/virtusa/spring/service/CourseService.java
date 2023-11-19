package org.virtusa.spring.service;

import java.util.Optional;
import java.util.Set;

import org.virtusa.spring.entity.Course;
import org.virtusa.spring.entity.Institute;

public interface CourseService {
	public Course addCourse(Long instituteId,Course course)throws Exception;
	//public Course addCourse(Course course);
	
	public Course updateCourse(Long courseId,Course course);
	
	public Set<Course> getCourses();
	
	public Course getCourse(Long courseId);
	
	public void deleteCourse(Long courseId);
	
	public Set<Course> getCoursesOfInstitute(Institute institute);
	
	
}
