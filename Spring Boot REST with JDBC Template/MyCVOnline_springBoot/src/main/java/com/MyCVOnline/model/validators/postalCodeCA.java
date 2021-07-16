package com.MyCVOnline.model.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=PostalCodeCAValidation.class)// points the class that will contains the constraint logic (validation)
@Target({ElementType.METHOD, ElementType.FIELD})//indicate the scope of your validation
@Retention(RetentionPolicy.RUNTIME)//will verify if the validation is being passed in the runtime 
public @interface postalCodeCA {

	//Defining the default postal code expected 
	
	public String value() default "[A-Z][0-9][A-Z][0-9][A-Z][0-9]";
	
	//Defining the default error message
	
	public String message() default "The postal code must be a\n a combination of letters and numbers. Example: K4L1W3";
	
	//Defining groups 
	
	
	Class<?>[] groups() default {};// The groups are used to identify if the validation is being executed at the indicated group level, by example before submitting the form it is a group 

	
	//Defining payloads 
	
	Class<? extends Payload>[] payload() default {}; //The payloads contains the data that could be stored in the metadata 
	
}
