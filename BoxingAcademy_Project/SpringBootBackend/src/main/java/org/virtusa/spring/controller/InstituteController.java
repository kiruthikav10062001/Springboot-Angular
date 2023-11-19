package org.virtusa.spring.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.virtusa.spring.entity.Institute;
import org.virtusa.spring.service.InstituteService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/institute")
public class InstituteController {
	
	@Autowired
	private InstituteService instituteService;
	
	@PostMapping
	public Institute addInstitute(@RequestBody Institute institute){
		return instituteService.addInstitute(institute);
		
	}
	
	//get all institutes
	@GetMapping("/allinstitutes")
	public Set<Institute> getInstitute(){
		Set<Institute> institutes=instituteService.getInstitutes();
		return institutes;
	}
	
	//get institute by id
	@GetMapping("/byid/{instituteId}")
	public Institute getInstitute(@PathVariable("instituteId") Long instituteId){
		Institute institute1=instituteService.getInstitute(instituteId);
		return institute1;
	}
	
	//update institute
	@PutMapping("/edit/{instituteId}")
	public Institute updateInstitute(@PathVariable("instituteId") Long instituteId,@RequestBody Institute institute){
		return instituteService.updateInstitute(instituteId, institute);
		
	}
	
	@DeleteMapping("/delete/{instituteId}")
	public void deleteInstitute(@PathVariable("instituteId") Long instituteId){
		instituteService.deleteInstitute(instituteId);
		
	}
	
	@GetMapping("/find/{instituteName}")
	public Institute findByInstituteName(@PathVariable("instituteName")String instituteName)
	{
		Institute institute2=instituteService.findByinstituteName(instituteName);
		return institute2;
	}
	
	@GetMapping("/find/{state}/{city}")
	public List<Institute> findByStateAndCity(@PathVariable("state")String state,@PathVariable("city")String city){
		List<Institute> institute3=instituteService.findByStateAndCity(state, city);
		return institute3;
		
	}
	
}
