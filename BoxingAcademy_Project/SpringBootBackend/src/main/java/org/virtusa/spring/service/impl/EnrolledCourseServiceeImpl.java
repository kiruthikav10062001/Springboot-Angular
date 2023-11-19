package org.virtusa.spring.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.spring.entity.EnrolledCourses;
import org.virtusa.spring.entity.Student;
import org.virtusa.spring.exception.CourseExistsException;
import org.virtusa.spring.exception.CourseNotFoundException;
import org.virtusa.spring.repository.EnrolledCourseRepository;
import org.virtusa.spring.service.EnrolledCourseService;

import org.virtusa.spring.entity.*;

@Service
public class EnrolledCourseServiceeImpl implements EnrolledCourseService {
	@Autowired
	private EnrolledCourseRepository enrolledCourseRepository;

	@Override
	public EnrolledCourses addEnrolledCourse(EnrolledCourses enrolledCourse) {
		if (this.enrolledCourseRepository.findByenrolledcourse(enrolledCourse.getStudent().getStudentId(),
				enrolledCourse.getCourse().getCourseId()) != null)
			throw new CourseExistsException("Course Already enrolled !!");
		return this.enrolledCourseRepository.save(enrolledCourse);

	}

	@Override
	public EnrolledCourses updateEnrolledCourse(EnrolledCourses enrolledCourse) {
		this.enrolledCourseRepository.findById((long) enrolledCourse.getEnrolledID())
				.orElseThrow(() -> new CourseNotFoundException(
						"applied course not found to update in this id : " + enrolledCourse.getEnrolledID()));
		EnrolledCourses c1 = enrolledCourseRepository.findById((long) enrolledCourse.getEnrolledID()).get();
		return this.enrolledCourseRepository.save(enrolledCourse);
	}

	@Override
	public Set<EnrolledCourses> getEnrolledCourses() {

		return new HashSet<>(this.enrolledCourseRepository.findAll());
	}

	@Override
	public EnrolledCourses getEnrolledCourse(Long enrolledId) {
		this.enrolledCourseRepository.findById(enrolledId).orElseThrow(
				() -> new CourseNotFoundException("applied course not found to update in this id : " + enrolledId));
		return this.enrolledCourseRepository.findById(enrolledId).get();
	}

	@Override
	public void deleteEnrolledCourse(Long enrolledId) {
		this.enrolledCourseRepository.findById(enrolledId).orElseThrow(
				() -> new CourseNotFoundException("applied course not found to update in this id : " + enrolledId));

		EnrolledCourses enrolledCourse = new EnrolledCourses();
		enrolledCourse.setEnrolledID(enrolledId);
		this.enrolledCourseRepository.delete(enrolledCourse);

	}

	@Override
	public Set<EnrolledCourses> getCourseofStudent(Student student) {
		// TODO Auto-generated method stub
		return this.enrolledCourseRepository.findByStudent(student);
	}

}
