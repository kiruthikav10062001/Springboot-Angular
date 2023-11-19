package org.virtusa.spring.service.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.virtusa.spring.entity.Institute;
import org.virtusa.spring.repository.InstituteRespository;
import org.virtusa.spring.exception.DomainFoundException;
import org.virtusa.spring.exception.DomainNotFoundException;
import org.virtusa.spring.service.InstituteService;

@Service
public class InstitueServiceImpl implements InstituteService{
	@Autowired
	private InstituteRespository instituteRepository;

	@Override
	public Institute addInstitute(Institute institute) {
		Institute i=instituteRepository.findByinstituteName(institute.getInstituteName());
		if(i!=null)
		{
			throw new DomainFoundException("Institute Already Present!!");
		}
		return instituteRepository.save(institute);
		
	}

	@Override
	public Institute updateInstitute(Long instituteId, Institute institute) {
		Institute institute1=instituteRepository.findById(instituteId).orElseThrow(()->new DomainNotFoundException("Institute with given Id not Found!!"));
		institute1.setInstituteName(institute.getInstituteName());
		institute1.setInstituteDescription(institute.getInstituteDescription());
		institute1.setInstituteEmail(institute.getInstituteEmail());
		institute1.setState(institute.getState());
		institute1.setCity(institute.getCity());
		institute1.setAddress(institute.getAddress());
		institute1.setContact(institute.getContact());
		institute1.setImageUrl(institute.getImageUrl());
		/*Institute institute1=instituteRepository.findById(instituteId).get();
		institute.setCreatedAt(institute1.getCreatedAt());*/
		return instituteRepository.save(institute1);
	}

	@Override
	public Set<Institute> getInstitutes() {
		return new LinkedHashSet<>(instituteRepository.findAll());
	}

	@Override
	public Institute getInstitute(Long instituteId) {
	    instituteRepository.findById(instituteId).orElseThrow(()->new DomainNotFoundException("Institute not found"));
	    return instituteRepository.findById(instituteId).get();
	}

	@Override
	public void deleteInstitute(Long instituteId) {
		Institute in=instituteRepository.findById(instituteId).orElseThrow(()->new DomainNotFoundException("Institute Not Found"));
		instituteRepository.delete(in);
		
	}
	
	/*@Override
	public Optional<Institute> findByinstituteName(String instituteName) {
		return instituteRepository.findByinstituteName(instituteName); 
	}*/
	/*
	@Override
	public List<Institute> findByStateOrCity(String state,String city) {
		return instituteRepository.findByStateOrCity(state, city);
	}
	*/
	@Override
	public List<Institute> findByStateAndCity(String state,String city) {
		return instituteRepository.findByStateAndCity(state, city);
	}

	@Override
	public Institute findByinstituteName(String instituteName) {
		return instituteRepository.findByinstituteName(instituteName); 
	}	
	
}