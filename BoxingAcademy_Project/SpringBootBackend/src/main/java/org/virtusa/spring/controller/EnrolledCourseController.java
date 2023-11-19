package org.virtusa.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.virtusa.spring.service.EnrolledCourseService;

import org.virtusa.spring.entity.*;


@RestController
@RequestMapping("/enrolledcourse")
public class EnrolledCourseController {
	@Autowired
	private EnrolledCourseService enrolledCourseService;
	@PostMapping("/addEnrolledCourse")
	public EnrolledCourses add(@RequestBody EnrolledCourses enrolledCourse) {
		return this.enrolledCourseService.addEnrolledCourse(enrolledCourse);
}
	@PutMapping("/editEnrolledCourse")
	public EnrolledCourses update(@RequestBody EnrolledCourses enrolledCourse) {
		return this.enrolledCourseService.updateEnrolledCourse(enrolledCourse);
	}

	@GetMapping("/viewEnrolledCourse")
	public Set<EnrolledCourses> enrolledCourses() {
		return this.enrolledCourseService.getEnrolledCourses();
	}
	@GetMapping("/{EnrolledId}")
	public EnrolledCourses enrolledCourse(@PathVariable("enrolledId") Long enrolledId) {
		return this.enrolledCourseService.getEnrolledCourse(enrolledId);
	}

	@DeleteMapping("/deleteEnrolledCourse/{enrolledId}")
	public void deleteEnrolledCourse(@PathVariable("enrolledId") Long enrolledId) {
		this.enrolledCourseService.deleteEnrolledCourse(enrolledId);
	}

	}