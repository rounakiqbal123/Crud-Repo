package com.marketingapp1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp1.entities.Lead;
import com.marketingapp1.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	private LeadRepository leadRepo;
	
	//localhost:8080/api/leads
	
	@GetMapping
	public List<Lead>getAllLeads(){
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	@DeleteMapping
	public void deleteOneLead(@RequestBody Lead lead) {
		leadRepo.deleteById(lead.getId());
	}
	
	@GetMapping("/{id}")
	public Lead getOneLead(@PathVariable("id") long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}
}
