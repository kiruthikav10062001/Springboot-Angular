package org.virtusa.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.virtusa.spring.entity.Institute;

public interface InstituteRespository extends JpaRepository<Institute,Long>{
	/*@Query(value="SELECT i from institute i where i.name=?")*/
	public Institute findByinstituteName(String instituteName);
	
	/*@Query(value="SELECT i from institute i where i.state=?1 or i.city=?2",nativeQuery=true)
	List<Institute> findByStateOrCity(String state,String city);
	*/
	@Query(value="Select * from institute i where i.state=?1 and i.city=?2",nativeQuery=true)
	List<Institute> findByStateAndCity(String state,String city);
	//Optional<Institute> findByinstituteId(Long instituteId);*/
}
