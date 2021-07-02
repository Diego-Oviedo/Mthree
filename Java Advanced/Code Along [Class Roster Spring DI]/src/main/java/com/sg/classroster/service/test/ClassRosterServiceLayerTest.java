package com.sg.classroster.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sg.classroster.dto.*;
import com.sg.classroster.dao.*;
import com.sg.classroster.dao.test.*;
import com.sg.classroster.service.*;

class ClassRosterServiceLayerTest {

	private ClassRosterService service;
	
	
	/*public ClassRosterServiceLayerTest() {
	    ClassRosterDAO dao = new ClassRosterDaoStubImpl();
	    ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

	    service = new ClassRosterServiceImpl(dao, auditDao);
	}*/
	
	ApplicationContext ctx = 
	        new ClassPathXmlApplicationContext("applicationContext.xml");
	    service = 
	        ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
	
	
	
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
	public void testCreateValidStudent() {
	    // ARRANGE
		//Create a new student with a non-existing Student ID 
	    Student student = new Student("0002");
	    student.setFirstName("Charles");
	    student.setLastName("Babbage");
	    student.setCohort(".NET-May-1845");
	    // ACT
	    //Add the student for the first time to the DAO
	    try {
	        service.createStudent(student);
	    } catch (ClassRosterDuplicateIdException
	            | ClassRosterDataValidationException
	            | ClassRosterPersistenceException e) {
	    // ASSERT
	    //Student will be successfully saved with no errors, the returning value will be null as there is no Student registered with that student id 		
	        fail("Student was valid. No exception should have been thrown.");
	    }
	}
	
	@Test
	void testAddDuplicatedStudent() {
	//ARRANGE
	//Create a new Student with the same student ID as the previous object
		Student student = new Student("0001");
	    student.setFirstName("Charles");
	    student.setLastName("Babbage");
	    student.setCohort(".NET-May-1845");	
		
	//ACT 
	//Create a new Student with the same student ID as the previous object
	    try {
	        service.createStudent(student);
	        fail("Expected DupeId Exception was not thrown.");
	    } catch (ClassRosterDataValidationException
	            | ClassRosterPersistenceException e) {
		
	//ASSERT
	//The returning value will not be null (it will be an Student associated with the indented student ID) 
	    	fail("Incorrect exception was thrown.");
	    } catch (ClassRosterDuplicateIdException e){
	        return;
	    }
	    
	}
	
	@Test
	void testAddStudentWithEmptyFields() {
	// ARRANGE
	//Create a Student with an empty value and a null value	
	    Student student = new Student("0002");
	    student.setFirstName("");//EMPTY FIELD
	    student.setLastName(null);//NULL VALUE 
	    student.setCohort(".NET-May-1845");

	// ACT
	//Tried to add the student to the DAO 
	    try {
	        service.createStudent(student);
	        fail("Expected ValidationException was not thrown.");
	    } catch (ClassRosterDuplicateIdException
	            | ClassRosterPersistenceException e) {
	// ASSERT
	//This will eventually fail    	
	        fail("Incorrect exception was thrown.");
	    } catch (ClassRosterDataValidationException e){
	        return;
	    }  
	}
	

	@Test
	public void testGetAllStudents() throws Exception {
	    // ARRANGE
	    Student testClone = new Student("0001");
	        testClone.setFirstName("Ada");
	        testClone.setLastName("Lovelace");
	        testClone.setCohort("Java-May-1845");

	    // ACT & ASSERT
	    assertEquals( 1, service.getAllStudents().size(), 
	                                   "Should only have one student.");
	    assertTrue( service.getAllStudents().contains(testClone),
	                              "The one student should be Ada.");
	}
	
	@Test
	public void testGetStudent() throws Exception {
	    // ARRANGE
	    Student testClone = new Student("0001");
	        testClone.setFirstName("Ada");
	        testClone.setLastName("Lovelace");
	        testClone.setCohort("Java-May-1845");

	    // ACT & ASSERT
	    Student shouldBeAda = service.getStudent("0001");
	    assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
	    assertEquals( testClone, shouldBeAda,
	                                   "Student stored under 0001 should be Ada.");

	    Student shouldBeNull = service.getStudent("0042");    
	    assertNull( shouldBeNull, "Getting 0042 should be null.");

	}
	
	@Test
	public void testRemoveStudent() throws Exception {
	    // ARRANGE
	    Student testClone = new Student("0001");
	        testClone.setFirstName("Ada");
	        testClone.setLastName("Lovelace");
	        testClone.setCohort("Java-May-1845");

	    // ACT & ASSERT
	    Student shouldBeAda = service.removeStudent("0001");
	    assertNotNull( shouldBeAda, "Removing 0001 should be not null.");
	    assertEquals( testClone, shouldBeAda, "Student removed from 0001 should be Ada.");

	    Student shouldBeNull = service.removeStudent("0042");    
	    assertNull( shouldBeNull, "Removing 0042 should be null.");

	}


	@AfterEach
	void tearDown() throws Exception {//Normally used to clean up after each test.
	}

	

}
