package com.sg.classroster.dao;

import java.util.*;
import com.sg.classroster.dto.*;
import java.io.*;

public class RosterDaoFileImpl implements ClassRosterDAO {
	
	public final String ROSTER_FILE;
	public static final String DELIMITER = "::";
	
	public RosterDaoFileImpl(){
	    ROSTER_FILE = "roster.txt";
	}

	public RosterDaoFileImpl(String rosterTextFile){
	    ROSTER_FILE = rosterTextFile;
	}
	
	
	private Map<String, Student> students = new HashMap<>();

	@Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException{
		loadRoster();
	    Student newStudent = students.put(studentId, student);
	    writeRoster();
	    return newStudent;
	}
	
	private Student unmarshallStudent(String studentAsText){
		String[] studentTokens = studentAsText.split(DELIMITER);//the split method will return an array of string  with every piece of data in each element 
	
		String studentId = studentTokens[0];// Given the pattern above, the student Id is in index 0 of the array.
		// Which we can then use to create a new Student object to satisfy
	    // the requirements of the Student constructor.
		Student studentFromFile = new Student(studentId);
		
		// Index 1 - FirstName
	    studentFromFile.setFirstName(studentTokens[1]);

	    // Index 2 - LastName
	    studentFromFile.setLastName(studentTokens[2]);

	    // Index 3 - Cohort
	    studentFromFile.setCohort(studentTokens[3]);
		
	    return studentFromFile;
	}
	
	private void loadRoster() throws ClassRosterPersistenceException {//the exception is being passed through the ClassRosterDaoException class
	   
		Scanner reader;//set reader as a local variable so the method will have access to the variable (if instanced inside the try, it won't be accessible to the rest of the method) 
		
	    try {
	        // Create Scanner for reading the file
	    	File file = new File(ROSTER_FILE);
		      reader = new Scanner(file);
		      reader.useDelimiter(DELIMITER);
	    } catch (FileNotFoundException e) {
	        throw new ClassRosterPersistenceException(
	                "-_- Could not load roster data into memory.", e);
	    }
	    
	    String currentLine;// currentLine holds the most recent line read from the file
	    
	    Student currentStudent;// currentStudent holds the most recent student unmarshalled
	    
	    
	    
	    while (reader.hasNextLine()) {// Process while we have more lines in the file
	        
	        currentLine = reader.nextLine();// get the next line in the file
	        //unmarshallStudent method will return an Student object.
	        currentStudent = unmarshallStudent(currentLine); // unmarshall the line into a Student with method previously created (transform line into a Sting [])

	        // We are going to use the student id as the map key for our student object.
	        // Put currentStudent into the map using student id as the key
	        students.put(currentStudent.getStudentId(), currentStudent);
	    }
	    
	    reader.close();//once done, close the reader
	}
	
	private String marshallStudent(Student student){
		String studentAsText = student.getStudentId() + DELIMITER; // Start with the student id, since that's supposed to be first.
		studentAsText += student.getFirstName() + DELIMITER; // FirstName
		studentAsText += student.getLastName() + DELIMITER;// LastName
		studentAsText += student.getCohort();// Cohort - don't forget to skip the DELIMITER here.
		
		return studentAsText;
	}
	
	private void writeRoster() throws ClassRosterPersistenceException { //It is the responsibility of the calling code to handle any errors that occur.
		PrintWriter out;
		
		try {
	        out = new PrintWriter(new FileWriter(ROSTER_FILE));
	    } catch (IOException e) {
	        throw new ClassRosterPersistenceException(
	                "Could not save student data.", e);
	    }
		
		String studentAsText;
	    List<Student> studentList = this.getAllStudents();
	    for (Student currentStudent : studentList) {
	        // turn a Student into a String
	        studentAsText = marshallStudent(currentStudent);
	        // write the Student object to the file
	        out.println(studentAsText);
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
		
	}
	

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList(students.values());
    }
    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException{
    	loadRoster();
        return students.get(studentId);
    }
    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

}
