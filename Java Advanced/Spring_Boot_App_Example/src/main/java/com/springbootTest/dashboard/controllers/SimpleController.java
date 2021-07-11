package com.springbootTest.dashboard.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SimpleController {
	
	@GetMapping("/method")
    public String[] helloWorld() {
        String[] result = {"Hello", "World", "!"};
        return result;
    }
	
	@PostMapping("/calculate")
	public String calculate(int operand1, String operator, int operand2) {
	    int result = 0;
	    switch (operator) {
	        case "+":
	            result = operand1 + operand2;
	            break;
	        case "-":
	            result = operand1 - operand2;
	            break;
	        case "*":
	            result = operand1 * operand2;
	            break;
	        case "/":
	            result = operand1 / operand2;
	            break;
	        default:
	            String message = String.format("operator '%s' is invalid", operator);
	            throw new IllegalArgumentException(message);
	    }
	    return String.format("%s %s %s = %s ", operand1, operator, operand2, result);
	}
	
	
	@DeleteMapping("/resource/{id}")
	//@ResponseStatus(HttpStatus.NO_CONTENT)
	public String delete(@PathVariable int id) {
		return String.format("The user with the ID: %s was sucessfully deleted !", id);
	    
	}
	
}
