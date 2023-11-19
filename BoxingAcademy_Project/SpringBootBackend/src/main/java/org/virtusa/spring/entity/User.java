package org.virtusa.spring.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {

	  @Id
      private String username;
	  private String email;
	  private String password;
	  private String mobileNumber;
	  
	  @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	  @JoinTable(name="USER_ROLE",
	  joinColumns= {
			  @JoinColumn(name="USER_ID")
	  },
	  inverseJoinColumns= {
			  @JoinColumn(name="ROLE_ID")
	  })
	  private Set<Role> roles;
	 
      
      @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
      private Set<Student> student=new HashSet<>();
     
     @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="user")
     private Set<Course> Course=new HashSet<>();
      
     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
     private Set<Institute> institute = new LinkedHashSet<>();
}
