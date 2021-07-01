package com.sg.classroster.service;

import com.sg.classroster.dto.*;
import com.sg.classroster.service.*;
import com.sg.classroster.dao.*;
import java.util.*;

public interface ClassRosterService {

	void createStudent(Student student) throws
										    ClassRosterDuplicateIdException,
										    ClassRosterDataValidationException,
										    ClassRosterPersistenceException;
	
	List<Student> getAllStudents() throws ClassRosterPersistenceException;
	
	Student getStudent(String studentId) throws ClassRosterPersistenceException;
	
	Student removeStudent(String studentId) throws ClassRosterPersistenceException;
	
}
