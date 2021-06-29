package com.sg.classroster.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import com.sg.classroster.dao.ClassRosterDAO;
import com.sg.classroster.dao.RosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import java.text.SimpleDateFormat;
import java.time.*;
import java.io.*;

class ClassRosterDaoFileImplTest {
	
	
	ClassRosterDAO testDao;//declaring an instance of the DAO, so we could test the aimed method 

	@BeforeAll
	static void setUpBeforeClass() throws Exception {//Normally used to set up external resources
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {//Normally used to clean up external resources
	}

	@BeforeEach
	void setUp() throws Exception {//Normally used to set things to a known good state before each test.
		
		Date current_date = new Date();
		SimpleDateFormat date_formatted = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String transaction_date = date_formatted.format(current_date);
		
		String testFile = "test_roster_"+transaction_date.toString()+".txt";
		new FileWriter(testFile);//this will ensure we are creating a new file (log) per test 
		//DAO is in an empty state since we created a new empty instance within our setUp method.
		testDao = new RosterDaoFileImpl(testFile);//instancing the DAO class with the overload constructor, by passing the new file name, so it won't interfere with production 
		
	}
	
	
	@Test
	public void testAddGetStudent() throws Exception {
	    
	//Arrange
	//The first step of this test is to create a new Student object 
		
		// Create our method test inputs
	    String studentId = "0001";
	    Student student = new Student(studentId);
	    student.setFirstName("Ada");
	    student.setLastName("Lovelace");
	    student.setCohort("Java-May-1845");
	    
	    
	    
	    
	//Act
	//Then we add that Student to the DAO (Act)
	//Next, we get the Student back out of the DAO and put it in another variable (Act)
	    

	    //  Add the student to the DAO
	    testDao.addStudent(studentId, student);
	    // Get the student from the DAO
	    Student retrievedStudent = testDao.getStudent(studentId);
	    
	//Assert    
	//Finally, we check to see that the data within the stored Student is equal to the retrieved Student from the DAO (Assert).

	    // Check the data is equal
	    assertEquals(student.getStudentId(),
	                retrievedStudent.getStudentId(),
	                "Checking student id.");
	    assertEquals(student.getFirstName(),
	                retrievedStudent.getFirstName(),
	                "Checking student first name.");
	    assertEquals(student.getLastName(), 
	                retrievedStudent.getLastName(),
	                "Checking student last name.");
	    assertEquals(student.getCohort(), 
	                retrievedStudent.getCohort(),
	                "Checking student cohort.");
	}
	
	@Test
	public void testAddGetAllStudents() throws Exception {
	
	//Arrange	
	//Create and add two Student objects to the DAO (Arrange)
		
	    // Create our first student
	    Student firstStudent = new Student("0001");
	    firstStudent.setFirstName("Ada");
	    firstStudent.setLastName("Lovelace");
	    firstStudent.setCohort("Java-May-1845");

	    // Create our second student
	    Student secondStudent = new Student("0002");
	    secondStudent.setFirstName("Charles");
	    secondStudent.setLastName("Babbage");
	    secondStudent.setCohort(".NET-May-1845");
	    
	//Act    
	//Get all of the Student objects from the DAO (Act)

	    // Add both our students to the DAO
	    testDao.addStudent(firstStudent.getStudentId(), firstStudent);
	    testDao.addStudent(secondStudent.getStudentId(), secondStudent);

	    // Retrieve the list of all students within the DAO
	    List<Student> allStudents = testDao.getAllStudents();

	//Assert    
	//Check to see that the DAO returned the 2 objects (Assert)
	    
	    // First check the general contents of the list
	    assertNotNull(allStudents, "The list of students must not null");
	    assertEquals(2, allStudents.size(),"List of students should have 2 students.");

	    // Then the specifics
	    assertTrue(testDao.getAllStudents().contains(firstStudent),
	                "The list of students should include Ada.");
	    assertTrue(testDao.getAllStudents().contains(secondStudent),
	            "The list of students should include Charles.");

	}
	
	@Test
	public void testRemoveStudent() throws Exception {
	//Arrange 
	//Create and add two Student objects to the DAO (Arrange)	
		
	    // Create two new students
	    Student firstStudent = new Student("0001");
	    firstStudent.setFirstName("Ada");
	    firstStudent.setLastName("Lovelace");
	    firstStudent.setCohort("Java-May-1945");

	    Student secondStudent = new Student("0002");
	    secondStudent.setFirstName("Charles");
	    secondStudent.setLastName("Babbage");
	    secondStudent.setCohort(".NET-May-1945");  

	    // Add both to the DAO
	    testDao.addStudent(firstStudent.getStudentId(), firstStudent);
	    testDao.addStudent(secondStudent.getStudentId(), secondStudent);

	//Act
	//Remove one of the Students from the DAO (Act)
 	    
	    // remove the first student - Ada
	    Student removedStudent = testDao.removeStudent(firstStudent.getStudentId());
	    
	//Assert   
	//Check to see Student removed was the same as the one deleted by the method (Assert)    

	    // Check that the correct object was removed.
	    assertEquals(removedStudent, firstStudent, "The removed student should be Ada.");

	    // Get all the students
	    List<Student> allStudents = testDao.getAllStudents();
	    
	//Assert   
	//Check to see that there is only one Student left in the DAO (Assert) 

	    // First check the general contents of the list
	    assertNotNull( allStudents, "All students list should be not null.");
	    assertEquals( 1, allStudents.size(), "All students should only have 1 student.");
	    
	//Assert
	//Check to see that the DAO returns null if we try to retrieve the removed Student (Assert) 	    

	    // Then the specifics
	    assertFalse( allStudents.contains(firstStudent), "All students should NOT include Ada.");
	    assertTrue( allStudents.contains(secondStudent), "All students should NOT include Charles.");    

	//Act
	//Remove the other Student from the DAO (Act)    
	    
	    // Remove the second student
	    removedStudent = testDao.removeStudent(secondStudent.getStudentId());
	    
	//Assert   
	//Check to see Student removed was the same as the one deleted by the method (Assert)    

	    // Check that the correct object was removed.
	    assertEquals( removedStudent, secondStudent, "The removed student should be Charles.");

	    // retrieve all of the students again, and check the list.
	    allStudents = testDao.getAllStudents();
	    
	//Assert   
	//Check to see that there are no Students in the DOA (Assert)    

	    // Check the contents of the list - it should be empty
	    assertTrue( allStudents.isEmpty(), "The retrieved list of students should be empty.");
	    
	//Assert   
	//Check to see that there are no Students in the DOA (Assert)      

	    // Try to 'get' both students by their old id - they should be null!
	    Student retrievedStudent = testDao.getStudent(firstStudent.getStudentId());
	    assertNull(retrievedStudent, "Ada was removed, should be null.");

	    retrievedStudent = testDao.getStudent(secondStudent.getStudentId());
	    assertNull(retrievedStudent, "Charles was removed, should be null.");

	}
	
	
	@AfterEach
	void tearDown() throws Exception {//Normally used to clean up after each test.
	}

}
