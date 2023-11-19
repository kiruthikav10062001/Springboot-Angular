package org.virtusa.spring.entity;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long courseId;
	private String courseName;
	private String courseDesc;
	private String courseTimings;
	private String courseDuration;
	private String courseCost;
	@JoinColumn(name="instituteId")
	@ManyToOne(fetch=FetchType.EAGER)
	private Institute institute;
	
	
	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseDesc() {
		return courseDesc;
	}


	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}


	public String getCourseTimings() {
		return courseTimings;
	}


	public void setCourseTimings(String courseTimings) {
		this.courseTimings = courseTimings;
	}


	public String getCourseDuration() {
		return courseDuration;
	}


	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}


	public String getCourseCost() {
		return courseCost;
	}


	public void setCourseCost(String courseCost) {
		this.courseCost = courseCost;
	}


	public Institute getInstitute() {
		return institute;
	}


	public void setInstitute(Institute institute) {
		this.institute = institute;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@JoinColumn(name = "createdByID")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	
}