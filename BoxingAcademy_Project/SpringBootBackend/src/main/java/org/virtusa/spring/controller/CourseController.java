package org.virtusa.spring.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.spring.entity.Course;
import org.virtusa.spring.entity.Institute;
import org.virtusa.spring.service.CourseService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//add course
	/*@PostMapping
	public Course addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
		
	}*/
	@PostMapping("/{instituteId}")
	public Course addCourse(@PathVariable(value="instituteId") Long instituteId,@RequestBody Course course) throws Exception{
		System.out.println(instituteId);
		return courseService.addCourse(instituteId,course);
		//return new ResponseEntity<String>("Course Added Succesfully",HttpStatus.CREATED);
	}
	
	//get all courses
	@GetMapping
	public Set<Course> getCourses(){
	   Set<Course> c=courseService.getCourses();
	   return c;
	  
	}
	
	//edit course
	/*@PutMapping("/edit/{courseId}")
	public ResponseEntity<?> updateCourse(@PathVariable(value="courseId")Long courseId,@RequestBody Course course)
	{
		courseService.updateCourse(courseId, course);
		return new ResponseEntity<String>("Course updated successfully",HttpStatus.OK);
	}*/
	@PutMapping("/edit/{courseId}")
	public Course updateCourse(@PathVariable(value="courseId")Long courseId,@RequestBody Course course)
	{
		return courseService.updateCourse(courseId, course);
	}
	
	//get course by id
	@GetMapping("/byid/{courseId}")
	public Course getCourse(@PathVariable("courseId")Long courseId) {
		return courseService.getCourse(courseId);
		
	}

		
	//delete course
	/*@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable("courseId")Long courseId) 
	{
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>("Deleted succesfully",HttpStatus.OK);
	}*/
	@DeleteMapping("/delete/{courseId}")
	public void deleteCourse(@PathVariable("courseId")Long courseId) 
	{
		courseService.deleteCourse(courseId);
		
	}
		
	//get courses of given institute id
	@GetMapping("/byinstituteId/{instituteId}")
	public Set<Course> getCoursesOfInstitute(@PathVariable("instituteId")Long instituteId)
	{
		Institute institute=new Institute();
		institute.setInstituteId(instituteId);
		Set<Course> courses=courseService.getCoursesOfInstitute(institute);
		return courses;
	}
	
	
}
