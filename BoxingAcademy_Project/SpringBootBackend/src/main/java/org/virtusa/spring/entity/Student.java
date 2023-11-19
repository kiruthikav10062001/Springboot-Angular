package org.virtusa.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long studentId;
	private String academyName;
	private String courseName;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String studentEmail;
	private String gender;
	private int age;
	private String address;
	private String state;
	private String city;
	public long getStudentId() {
		return studentId;
	}

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<EnrolledCourses> enrolledCourse= new HashSet<>();
	
	@JoinColumn(name = "createdByID")
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
}
