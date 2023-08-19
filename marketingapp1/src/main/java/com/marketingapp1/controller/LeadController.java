package com.marketingapp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marketingapp1.entities.Lead;
import com.marketingapp1.services.LeadService;

@Controller
public class LeadController {
	
	//http://localhost:8080/viewCreateLead
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewCreateLead")
	public String viewCreateLeadForm(){
		return "create_registration";
	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(Lead lead){
		leadService.saveLead(lead);
		return "create_registration";
	}
}
