package org.virtusa.spring.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.spring.entity.AppliedCourse;
import org.virtusa.spring.service.AppliedCourseService;

import org.virtusa.spring.exception.*;
import org.virtusa.spring.entity.*;
import org.virtusa.spring.service.*;
import org.virtusa.spring.repository.*;
@Service
public class AppliedCourseServiceImpl implements AppliedCourseService{
	@Autowired
	private AppliedCourseRepository appliedCourseRepository;
	@Autowired
	private EnrolledCourseRepository enrolledCourseRepository;
	
	@Override
	public AppliedCourse addAppliedCourse(AppliedCourse appliedCourse) {
		if(this.appliedCourseRepository.findByappliedcourse(appliedCourse.getStudent().getStudentId(),appliedCourse.getCourse().getCourseId())!=null) 
			throw new CourseExistsException("Course Already enrolled !!"); 
		EnrolledCourses enrolledCourse=new EnrolledCourses();
		enrolledCourse.setCourse(appliedCourse.getCourse());
		enrolledCourse.setStudent(appliedCourse.getStudent());
		this.enrolledCourseRepository.save(enrolledCourse);
		return this.appliedCourseRepository.save(appliedCourse);
	}

	@Override
	public AppliedCourse updateAppliedCourse(AppliedCourse appliedCourse) {
		this.appliedCourseRepository.findById(appliedCourse.getApplicationId())
		.orElseThrow(()->new CourseNotFoundException("applied course not found to update in this id : "+appliedCourse.getApplicationId()));
		AppliedCourse c1=appliedCourseRepository.findById(appliedCourse.getApplicationId()).get();
		if(c1!=null) throw new CourseFoundException("Not applied for this course !!"); 
		return this.appliedCourseRepository.save(appliedCourse);
	}

	@Override
	public Set<AppliedCourse> getAppliedCourses() {
		return new HashSet<>(this.appliedCourseRepository.findAll());
	}

	@Override
	public AppliedCourse getAppliedCourse(Long applicationId) {
		this.appliedCourseRepository.findById(applicationId)
		.orElseThrow(()->new CourseNotFoundException("applied course not found to update in this id : "+applicationId));
		return this.appliedCourseRepository.findById(applicationId).get();
	}

	@Override
	public void deleteAppliedCourse(Long applicationId) {
		this.appliedCourseRepository.findById(applicationId)
		.orElseThrow(()->new CourseNotFoundException("applied course not found to update in this id : "+applicationId));
		AppliedCourse appliedCourse =new AppliedCourse();
		appliedCourse.setApplicationId(applicationId);
		this.appliedCourseRepository.delete(appliedCourse);
		
	}

}
