package com.MyCVOnline.controller;


import java.io.IOException;
import java.util.ArrayList;
import com.MyCVOnline.model.*;
import com.MyCVOnline.model.service.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/Applicants")
@ComponentScan("com.MyCVOnline") 
public class ApplicantController { 

	
	/***********Service's Dependency******************/
	@Autowired
	ApplicantService applicant_service;
	
	@Autowired
	ApplicantExperienceService applicant_experience_service;
	
	@Autowired
	ApplicantEducationService applicant_education_service;
	
	@Autowired
	ApplicantOtherSkillService applicant_other_skill_service;
	
	@Autowired
	ApplicantTechSkillService applicant_tech_skill_service;
	
	@Autowired
	ApplicationService application_service;
	
	@Autowired
	CompanyEmployeeService employee_service;
	
	@Autowired
	CompanyPositionService position_service;
	
	@Autowired
	CompanyService company_service;

	@Autowired
	PositionExperienceService position_experience_service;
	
	@Autowired
	PositionQualificationSarvice position_qualification_service;
	
	 @Autowired
	 MessageSource messageSource;

	 String action = "";
	 
	
	 // This method will list all existing applicants .    
	 	@RequestMapping(value = { "/All-Applicants" }, method = RequestMethod.GET)
	    public String getAllApplicants(ModelMap model, HttpServletResponse response) {
	  
	        ArrayList<Applicant> applicants = applicant_service.retreiveApplicants();
	        model.addAttribute("applicants", applicants);
	        
	        return "All-Applicants";
	    }
	 	
	 	 // This method will list all display .    
	 	@RequestMapping(value = { "/All-Applicants_Pictures" }, method = RequestMethod.GET)
	    public void getAllApplicantPictures(@PathVariable String applicantID, HttpServletResponse response,HttpServletRequest request) 
	            throws ServletException, IOException{
	 		
	 		System.out.println("Works when calling controller \n");
	 		
	 		Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	        response.getOutputStream().write(applicant.getProfilePicture());


	        response.getOutputStream().close();
	        //applicant_service.displayApplicantProfilePicture(applicantID, response);
			

	    }
	 	  
	      
	    // This method will provide the medium to add a new applicant.     
	    @RequestMapping(value = { "/New-Applicant" }, method = RequestMethod.GET)
	    public String newApplicant(ModelMap model) {
	    	
	        Applicant applicant = new Applicant();
	        model.addAttribute("applicant", applicant);

	        return "registration"; 
	    }
	      
	     // This method will be called on form submission, handling POST request for
	     // saving an applicant in database. It also validates the user input     
	    @RequestMapping(value = { "/New-Applicant" }, method = RequestMethod.POST)
	    public String saveApplicant(@Valid Applicant applicant, BindingResult result,
	            ModelMap model) {
	    	
	        if (result.hasErrors()) {
	        
	        	model.addAttribute("error_adding_applicant","ERROR: " + result.getFieldError()); 
	            
	            return "registration";
	            }
 	        
	        	if(applicant_service.isApplicantUsernameAlreadyExists(applicant.getUsername())){
	        	
	            FieldError IDError =new FieldError("applicant","username",messageSource.getMessage("non.unique.ID", new String[]{applicant.getUsername()}, null));
	            result.addError(IDError);
	            
	            return "registration";
	        	}
	        	else if(!result.hasErrors()) {
	        		 
	        		applicant_service.insertApplicant(applicant);
	        		  
	        	}
	        	
     	        model.addAttribute("success", "Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " registered successfully");
     	        return "success";
	    }
	        
	    
	    // This method will provide the medium to view the existing applicant.     
	    @RequestMapping(value = { "/view-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String viewApplicant(@PathVariable String applicantID, ModelMap model) {
	    	Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	        model.addAttribute("applicant", applicant);
	        model.addAttribute("edit", true);
	        
	        ArrayList<ApplicantEducation> educations = applicant_education_service.retreiveApplicantEducationsByID(applicantID);
	        model.addAttribute("applicant_educations", educations);
	        
	        ArrayList<ApplicantExperience> experiences = applicant_experience_service.retreiveApplicantExperiencesByID(applicantID);
	        model.addAttribute("applicant_experiences", experiences);
	        
	        return "Applicant";
	    }
	    
	    
	    
	     // This method will provide the medium to update an existing applicant.     
	    @RequestMapping(value = { "/edit-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String editApplicant(@PathVariable String applicantID, ModelMap model) {
	    	
	    	Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	        model.addAttribute("applicant", applicant);
	        
	        model.addAttribute("education", new ApplicantEducation()); 
	        model.addAttribute("experience", new ApplicantExperience());
	        
	        ArrayList<ApplicantEducation> educations = applicant_education_service.retreiveApplicantEducationsByID(applicantID);
	        model.addAttribute("applicant_educations", educations);
	        ArrayList<ApplicantExperience> experiences = applicant_experience_service.retreiveApplicantExperiencesByID(applicantID);
	        model.addAttribute("applicant_experiences", experiences);

	        
	        
	        return "Applicant_edit";
	    }
	      
	    
	     // This method will be called on form submission, handling POST request for
	     // updating applicant in database. It also validates the user input
	    @RequestMapping(value = { "/edit-{applicantID}-applicant" }, method = RequestMethod.POST)
	    public String updateApplicant(@Valid Applicant applicant, BindingResult result,
	            ModelMap model, @PathVariable String applicantID) {
	  
	    	
	    	//if the userame to edit already exists and is different that the previous one -> you will have to choose another oner 
	        if(applicant_service.isApplicantUsernameAlreadyExists(applicant.getUsername()) && !applicant.getUsername().equalsIgnoreCase(applicant_service.retreiveApplicant(applicant.getApplicantID()).getUsername())){
	        	
	        	model.addAttribute("alert_status_edit_applicant", "warning");
		    	model.addAttribute("error_editing_applicant", "Username already exists");
	            
		    	editApplicant(applicantID,model);

		        return "Applicant_edit";
	        	}
	    	
	        if (result.hasErrors()) {
	        	
	        	model.addAttribute("alert_status_edit_applicant", "danger");
	        	model.addAttribute("error_editing_applicant","Error when filling fileds"); 
	            
	        	ArrayList<ApplicantEducation> educations = applicant_education_service.retreiveApplicantEducationsByID(applicantID);
		        model.addAttribute("applicant_educations", educations);    
		        
		        ArrayList<ApplicantExperience> experiences = applicant_experience_service.retreiveApplicantExperiencesByID(applicantID);
		        model.addAttribute("applicant_experiences", experiences);
		        
		        model.addAttribute("education", new ApplicantEducation()); 
		        model.addAttribute("experience", new ApplicantExperience());
	        	
	        	//editApplicant(applicantID,model);

		        return "Applicant_edit";
	        }
	        
	        if(!applicant_service.isApplicantIDAlreadyExists(applicantID)){
	            
	            model.addAttribute("error_editing_applicant","The Applicant " + applicant.getFirstName() + " " + applicant.getLastName()+ " haven't been previously registered\n Please register as a new applicant.\n "); 
	            
	            return "registration";
	        }
	        
	        else if(!result.hasErrors()) {
       		 
	        	applicant_service.updateApplicant(applicant);
	        	model.addAttribute("alert_status_edit_applicant", "success");
		        model.addAttribute("success", "Applicant successfully updated!");
		        
		        editApplicant(applicantID,model);

		        return "Applicant_edit";
        		  
        	}
	        
	        editApplicant(applicantID,model);
	        
	        return "Applicant_edit";
	    }
	    
	    
	          
	     // This method will delete an applicant by it's ID value.     
	    @RequestMapping(value = { "/delete-{applicantID}-applicant" }, method = RequestMethod.GET)
	    public String deleteApplicant(@PathVariable String applicantID,ModelMap model) {
	    	
	    	applicant_service.deleteApplicant(applicantID);
	        
	    	model.addAttribute("alert_status_edit_applicant", "info");
	    	model.addAttribute("success", "Applicant successfully deleted!");
	    	
	    	ArrayList<Applicant> applicants = applicant_service.retreiveApplicants();
	        model.addAttribute("applicants", applicants);
	        
	        return "All-Applicants";
	    	
	    }
	    
	    
	    //Form submission by POST request to save an applicant's experience in database. It also validates the user input     
	    @RequestMapping(value = { "/add_applicant_experience-{applicantID}" }, method = RequestMethod.POST)
	    public String saveApplicant_experience(@PathVariable String applicantID ,@Valid ApplicantExperience experience, BindingResult result,
	            ModelMap model) {
	    	
	    		Applicant applicant = applicant_service.retreiveApplicant(applicantID);
	    	
	    	
	        if (result.hasErrors()) {
	        	
	 
	        	model.addAttribute("alert_status_add_applicant_experience", "danger");
	        	model.addAttribute("error_adding_applicant_experience","Error when filling fileds");
	            
	        	editApplicant(applicantID,model);
	        	
	        	return "Applicant_edit";
	        	
	            }
	        
	        	else if(!result.hasErrors()) {
	        		 
	        		applicant_experience_service.insertApplicantExperience(applicant, experience);
	        		
	        		model.addAttribute("alert_status_add_applicant_experience", "success");
			        model.addAttribute("success_adding_applicant_experience", "Experience successfully added!");
	        		
	        		editApplicant(applicantID,model);

	        	}

		        editApplicant(applicantID,model);
		        
    	        return "Applicant_edit";
	    }
	    
	    
	 // This method will delete an applicant by it's ID value.     
	    @RequestMapping(value = { "/delete_applicant_{experienceTitle}_experience-{applicantID}" }, method = RequestMethod.GET)
	    public String deleteApplicant_experience(@PathVariable String experienceTitle,@PathVariable String applicantID,ModelMap model) {
	 
	    	
	    	applicant_experience_service.deleteApplicantExperience(applicantID, experienceTitle);
	        
	    	model.addAttribute("alert_status_edit_applicant_experience", "info");
	    	model.addAttribute("success_deleting_applicant_experience", "Experience successfully deleted!");
	    	
	    	 editApplicant(applicantID,model);
	        
	        return "Applicant_edit";
	    	
	    }

		  //Form submission by POST request to save an applicant's education in database. It also validates the user input     
		    @RequestMapping(value = { "/add_applicant_education-{applicantID}" }, method = RequestMethod.POST)
		    public String saveApplicant_education(@PathVariable String applicantID ,@Valid ApplicantEducation education, BindingResult result,
		            ModelMap model) {
		    	
		    		Applicant applicant = applicant_service.retreiveApplicant(applicantID);
		    	
		    	
		        if (result.hasErrors()) {
		        	
		 
		        	model.addAttribute("alert_status_add_applicant_education", "danger");
		        	model.addAttribute("error_adding_applicant_education","Error when filling fileds");
		            
		        	editApplicant(applicantID,model);
		        	
		        	return "Applicant_edit";
		        	
		            }
		        
		        	else if(!result.hasErrors()) {
		        		 
		        		applicant_education_service.insertApplicantEducation(applicant, education);
		        		
		        		model.addAttribute("alert_status_add_applicant_education", "success");
				        model.addAttribute("success_adding_applicant_education", "Education successfully added!");
		        		
		        		editApplicant(applicantID,model);
	
		        	}
	
			        editApplicant(applicantID,model);
			        
	    	        return "Applicant_edit";
		    }
	    
	    
		 // This method will delete an applicant by it's ID value.     
		    @RequestMapping(value = { "/delete_applicant_{educationTitle}_education-{applicantID}" }, method = RequestMethod.GET)
		    public String deleteApplicant_education(@PathVariable String educationTitle,@PathVariable String applicantID,ModelMap model) {
		 
		    	
		    	applicant_education_service.deleteApplicantEducation(applicantID, educationTitle);
		        
		    	model.addAttribute("alert_status_edit_applicant_education", "info");
		    	model.addAttribute("success_deleting_applicant_education", "Education successfully deleted!");
		    	
		    	 editApplicant(applicantID,model);
		        
		        return "Applicant_edit";
		    	
		    }
	 
	 
}
