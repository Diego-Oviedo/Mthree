package com.springbootTest.app.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import com.springbootTest.app.data.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice//indicates our class will assist all controllers in our project.(AOP)
@RestController// indicates our class is able to serve an HTTP response on behalf of a controller.
public class ToDoControllerExceptionHandler extends ResponseEntityExceptionHandler {//ResponseEntityExceptionHandler class contains a bunch of exception handling 

	private static final String CONSTRAINT_MESSAGE = "Could not save your item. "
            + "Please ensure it is valid and try again.";

		
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)//annotate each method to indicate which exception it's handling:
    //accept a Java exception and WebRequest as parameters and return a ResponseEntity<T>
    public final ResponseEntity<Error> handleSqlException(
            SQLIntegrityConstraintViolationException ex,//exception parameter
            WebRequest request) {//web request

        Error err = new Error();
        err.setMessage(CONSTRAINT_MESSAGE);
        return new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);//we return an instance of Error inside and anonymize our exception details.
    }
	
}
