package org.virtusa.spring.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.virtusa.spring.entity.JwtRequest;
import org.virtusa.spring.entity.JwtResponse;
import org.virtusa.spring.entity.User;
import org.virtusa.spring.repository.UserRepository;
import org.virtusa.spring.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest)throws Exception {
		String userName=jwtRequest.getUserName();
		String userPassword=jwtRequest.getUserPassword();
		authenticate(userName,userPassword);
		
		UserDetails userDetails=loadUserByUsername(userName);
		
		
		String newGeneratedToken=jwtUtil.generateToken(userDetails);
		
		User user=userRepository.findById(userName).get();
		
		return new JwtResponse(user,newGeneratedToken);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findById(username).get();
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					getAuthority(user)
			);
		}
		else {
			throw new UsernameNotFoundException("Username is not valid");
		}
	}
	private Set getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities=new HashSet<>();
		user.getRoles().forEach(role->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		});
		return authorities;
	}
	
	private void authenticate(String userName,String userPassword) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
		}
		catch(DisabledException e) {
			throw new Exception("User is defined");
		}
		catch(BadCredentialsException e) {
			throw new Exception("BAd credentials from user");
		}
	}

}
