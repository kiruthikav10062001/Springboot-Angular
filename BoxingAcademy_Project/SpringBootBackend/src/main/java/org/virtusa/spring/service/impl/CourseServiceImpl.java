package org.virtusa.spring.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.spring.entity.Course;
import org.virtusa.spring.entity.Institute;
import org.virtusa.spring.exception.CourseFoundException;
import org.virtusa.spring.exception.CourseNotFoundException;
import org.virtusa.spring.exception.DomainFoundException;
import org.virtusa.spring.exception.DomainNotFoundException;
import org.virtusa.spring.repository.CourseRepository;
import org.virtusa.spring.repository.InstituteRespository;
import org.virtusa.spring.service.CourseService;
import org.virtusa.spring.service.InstituteService;

@Service
public class CourseServiceImpl implements CourseService{
	@Autowired 
	private CourseRepository courseRepository;
	@Autowired
	private InstituteService instituteService;
	/*@Override
	public Course addCourse(Course course) {
		
		Course course_1=courseRepository.findByCourseName(course.getCourseName());
		
		if(course_1!=null)
		{
			throw new DomainFoundException("Course Already Present!!");
		}
		return courseRepository.save(course);
	}*/
	@Override
	public Course addCourse(Long instituteId,Course course) throws Exception {
		
		Course course_1=courseRepository.findByCourseName(course.getCourseName());
		
		if(course_1!=null)
		{
			throw new DomainFoundException("Course Already Present!!");
		}
		Institute institute=instituteService.getInstitute(instituteId);
		System.out.println(institute.toString());
//		throw new Exception("debug exception");
		
		course.setInstitute(institute);
		return courseRepository.save(course);
	}
	@Override
	public Course updateCourse(Long courseId,Course course) {
		Course c=courseRepository.findById(courseId).orElseThrow(()->new DomainNotFoundException("Course Not found!!"));
	    c.setCourseName(course.getCourseName());
	    c.setCourseDesc(course.getCourseDesc());
	    c.setCourseDuration(course.getCourseDuration());
	    c.setCourseTimings(course.getCourseTimings());
	    c.setCourseCost(course.getCourseCost());
	    return courseRepository.save(c);
	
	}

	@Override
	public Set<Course> getCourses() {
		return new HashSet<>(courseRepository.findAll());
	}

	@Override
	public Course getCourse(Long courseId) {
		courseRepository.findById(courseId).orElseThrow(()->new DomainNotFoundException("Course Not Found!!"));
		return courseRepository.findById(courseId).get();
	}

	@Override
	public void deleteCourse(Long courseId) {
		Course course=courseRepository.findById(courseId).orElseThrow(()->new DomainNotFoundException("Course Not Found!!"));
		courseRepository.delete(course);
	}
	

	@Override
	public Set<Course> getCoursesOfInstitute(Institute institute) {
		return courseRepository.findByInstitute(institute);
	}

	
	

	
	

}
