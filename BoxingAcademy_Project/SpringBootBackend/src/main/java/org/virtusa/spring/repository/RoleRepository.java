package org.virtusa.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.spring.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,String>{
	

}
