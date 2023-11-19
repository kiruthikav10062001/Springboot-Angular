package org.virtusa.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.spring.entity.Student;
import org.virtusa.spring.service.StudentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentServcie;

	@GetMapping("/viewStudent")
	public Set<Student> getAllStudents(){
		return this.studentServcie.getStudents();
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return this.studentServcie.addStudent(student);
		
	}
	
	@GetMapping("/{studentId}")
	public Student student(@PathVariable("studentId")long studentId)
	{
		return this.studentServcie.getStudent(studentId);
	}
	
	@PutMapping("/editStudent/{studentId}")
	public Student updateStudent(@PathVariable("studentId")Long studentId,@RequestBody Student student)
	{
		return this.studentServcie.updateStudent(studentId,student);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public void deleteStudent(@PathVariable("studentId")long studentId)
	{
		this.studentServcie.deleteStudent(studentId);
	}
}
