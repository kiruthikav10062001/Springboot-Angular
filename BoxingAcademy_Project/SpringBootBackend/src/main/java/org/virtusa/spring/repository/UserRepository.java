package org.virtusa.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.virtusa.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
	

}
