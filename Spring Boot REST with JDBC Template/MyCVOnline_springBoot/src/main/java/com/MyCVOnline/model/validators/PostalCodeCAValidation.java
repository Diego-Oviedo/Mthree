package com.MyCVOnline.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PostalCodeCAValidation implements ConstraintValidator<postalCodeCA, String> {

	public void initialize(postalCodeCA postalCode) {
		
		PC_CA_Pattern = postalCode.value();
	}

	public boolean isValid(String postal_conde_introduced, ConstraintValidatorContext context) {
		
		boolean codigo_validado;
		
		if(postal_conde_introduced!=null) {
			
			codigo_validado=postal_conde_introduced.matches(PC_CA_Pattern);
		}else 
			return codigo_validado=true;	
		
		return codigo_validado;
	}

	
	
	private String PC_CA_Pattern;
}
