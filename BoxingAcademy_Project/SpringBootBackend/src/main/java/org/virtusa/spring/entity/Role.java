package org.virtusa.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	private String roleName;
	private String roleAccess;
	public Role() {
		
	}
	public Role(String roleName, String roleAccess) {
		super();
		this.roleName = roleName;
		this.roleAccess = roleAccess;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleAccess() {
		return roleAccess;
	}
	public void setRoleAccess(String roleAccess) {
		this.roleAccess = roleAccess;
	}
	

}
