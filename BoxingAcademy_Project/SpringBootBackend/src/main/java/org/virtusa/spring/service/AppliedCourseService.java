package org.virtusa.spring.service;

import java.util.Set;

import org.virtusa.spring.entity.*;

public interface AppliedCourseService {
	public AppliedCourse addAppliedCourse(AppliedCourse appliedCourse);

	public AppliedCourse updateAppliedCourse(AppliedCourse appliedCourse);

	public Set<AppliedCourse> getAppliedCourses();

	public AppliedCourse getAppliedCourse(Long applicationId);

	public void deleteAppliedCourse(Long applicationId);
}
