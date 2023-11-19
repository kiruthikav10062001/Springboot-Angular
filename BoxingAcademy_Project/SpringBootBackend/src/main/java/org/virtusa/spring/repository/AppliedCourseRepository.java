package org.virtusa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.virtusa.spring.entity.*;

public interface AppliedCourseRepository extends JpaRepository<AppliedCourse,Long>{

	public AppliedCourse findByCourse(Course course);

	public Object findByStudent(Student student);

	/* public Object findByappliedcourse(long studentId, Long courseId); */
	
	@Query(value = "select * from appliedcourse s where s.student_id = :studentId and s.course_id = :courseId", nativeQuery = true)
	public Object findByappliedcourse(@Param("studentId") long studentId, @Param("courseId") long courseId);

	}

