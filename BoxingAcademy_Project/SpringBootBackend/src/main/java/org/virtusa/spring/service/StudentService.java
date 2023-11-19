package org.virtusa.spring.service;

import java.util.Set;

import org.virtusa.spring.entity.Student;

public interface StudentService {
	public Student addStudent(Student student);
	public Student updateStudent(Long studentId,Student student);
	public Set<Student> getStudents();
	public Student getStudent(long studentId);
	public void deleteStudent(Long studentId);

}
