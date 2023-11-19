package org.virtusa.spring.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appliedcourse")
public class AppliedCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long applicationId;
	
	 @JoinColumn(name = "studentId")
		@ManyToOne(fetch = FetchType.EAGER)
	    private Student student;
	    
	    @JoinColumn(name = "courseId")
		@ManyToOne(fetch = FetchType.EAGER)
	    private Course course;
	    
	    @JoinColumn(name = "userId")
		@ManyToOne(fetch = FetchType.EAGER)
	    private User user;
}
