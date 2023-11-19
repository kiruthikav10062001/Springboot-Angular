package org.virtusa.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.virtusa.spring.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	public Student findByStudentEmail(String studentEmail);
}
