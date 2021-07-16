package com.MyCVOnline.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MyCVOnline.model.Applicant;
import com.MyCVOnline.model.service.ApplicantService;

@Controller
@RequestMapping("/Companies")
@ComponentScan("com.MyCVOnline") 
public class CompanyController {
	
	
	/***********Service's Dependency******************/
	@Autowired
	ApplicantService applicant_service;
	
	
	
	 // This method will list all existing employees.    
 	@RequestMapping(value = { "/All-Applicants" }, method = RequestMethod.GET)
    public String getAllApplicants(ModelMap model, HttpServletResponse response) {
  
        ArrayList<Applicant> applicants = applicant_service.retreiveApplicants();
        model.addAttribute("applicants", applicants);
        
        return "All-Applicants";
    }

}
