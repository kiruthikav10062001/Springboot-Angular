package org.virtusa.spring.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.virtusa.spring.entity.Role;
import org.virtusa.spring.entity.User;
import org.virtusa.spring.repository.RoleRepository;
import org.virtusa.spring.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User registerNewUser(User user) {
		Role role=roleRepository.findById("User").get();
		Set<Role> userRoles=new HashSet<Role>();
		userRoles.add(role);
		user.setRoles(userRoles);
		user.setPassword(getEncodedPassword(user.getPassword()));
		return userRepository.save(user);
		
	}
	
	public void initRolesAndUser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleAccess("Admin Role");
		roleRepository.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("User");
		userRole.setRoleAccess("User Role");
		roleRepository.save(userRole);
		
		User adminUser=new User();
		adminUser.setUsername("admin");
		adminUser.setEmail("admin@gmail.com");
		adminUser.setMobileNumber("890765432");
		adminUser.setPassword(getEncodedPassword("admin@gmail"));
		
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRoles(adminRoles);
		userRepository.save(adminUser);
		
		/*User user=new User();
		user.setUserFirstName("user");
		user.setUserLastName("u");
		user.setUserName("user123");
		user.setUserPassword(getEncodedPassword("user@gmail"));
		
		Set<Role> userRoles=new HashSet<>();
		userRoles.add(userRole);
		user.setRoles(userRoles);
		userRepository.save(user);	*/
	}
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
