package org.virtusa.spring.repository;



import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.virtusa.spring.entity.EnrolledCourses;


import org.virtusa.spring.entity.*;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourses,Long> {

	public void save(AppliedCourse appliedCourse);

	/* Object findByenrolledcourse(long studentId, Long courseId); */
	public Set<EnrolledCourses> findByStudent(Student student);
	public Object findByCourse(Course course);
	
	

	@Query(value = "select * from enrolledcourse s where s.user_id = :userId and s.course_id = :courseId", nativeQuery = true)
	public Object findByenrolledcourse(@Param("userId") long userId, @Param("courseId") long courseId);

	/* public Optional<EnrolledCourses> findById(int enrolledID); */
}
