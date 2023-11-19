package org.virtusa.spring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

	private User user;
	private String jwtToken;
	public JwtResponse(User user, String jwtToken) {
		super();
		this.user = user;
		this.jwtToken = jwtToken;
	}

}
