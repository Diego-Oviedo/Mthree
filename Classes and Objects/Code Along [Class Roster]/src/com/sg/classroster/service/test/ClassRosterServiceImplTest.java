package com.sg.classroster.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterDAO;
import com.sg.classroster.service.ClassRosterService;

class ClassRosterServiceImplTest {

	private ClassRosterService service;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {//Normally used to set up external resources
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {//Normally used to clean up external resources
	}

	@BeforeEach
	void setUp() throws Exception {//Normally used to set things to a known good state before each test.
	
		
	}
	
	@Test
	void testAddDuplicatedStudent() {
	//ARRANGE
	//Create a new student with a non-existing Student ID 
		
		
	//ACT 
	//Add the student for the first time to the DAO
		
		
	//ASSERT
	//Student will be successfully saved with no errors, the returning value will be null as there is no Student registered with that student id 	
		
			
	//ARRANGE 
	//Create a new Student with the same student ID as the previous object
		
		
	//ASSERT
	//The returning value will not be null (it will be an Student associcated with the indented student ID) 
		
		
	}
	
	@Test
	void testAddStudentWithEmptyFields() {
		
	}
	


	@AfterEach
	void tearDown() throws Exception {//Normally used to clean up after each test.
	}

	

}
