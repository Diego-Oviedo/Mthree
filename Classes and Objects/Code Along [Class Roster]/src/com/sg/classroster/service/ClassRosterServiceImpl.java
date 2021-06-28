package com.sg.classroster.service;

import java.util.*;
import com.sg.classroster.dao.ClassRosterPersistenceException;
import com.sg.classroster.dao.RosterDaoFileImpl;
import com.sg.classroster.dto.Student;
import java.text.SimpleDateFormat;

public class ClassRosterServiceImpl implements ClassRosterService {
	
	private RosterDaoFileImpl dao;

	public ClassRosterServiceImpl(RosterDaoFileImpl dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void createStudent(Student student) throws ClassRosterDuplicateIdException,
			ClassRosterDataValidationException, ClassRosterPersistenceException {
		
		if (dao.getStudent(student.getStudentId()) != null) {
			
			throw new ClassRosterDuplicateIdException("The student is already registered");
		}
		
		
		if (student.getFirstName() == null || student.getFirstName().equals("")) {
			
			throw new ClassRosterDataValidationException("The student first name is required and can not be null or empty!");
		}
		
		if (student.getLastName() == null || student.getLastName().equals("")) {
			
			throw new ClassRosterDataValidationException("The student last name is required and can not be null or empty!");
		}
		
		if (student.getCohort() == null || student.getCohort().equals("")) {
			
			throw new ClassRosterDataValidationException("The student cohort is required and can not be null or empty!");
		}
		
		
		Date current_date = new Date();//record an entry to an audit log every time a Student object is created or removed from the system
		SimpleDateFormat date_formatted = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String transaction_date = date_formatted.format(current_date);
		
		student.getTransactionRecord().add(transaction_date);
	}

	@Override
	public List<Student> getAllStudents() throws ClassRosterPersistenceException {//pass-through method
		
		return dao.getAllStudents();
	}

	@Override
	public Student getStudent(String studentId) throws ClassRosterPersistenceException {//pass-through method
		
		return dao.getStudent(studentId);
	}

	@Override
	public Student removeStudent(String studentId) throws ClassRosterPersistenceException {//pass-through method
		
		Student student_deleted = dao.removeStudent(studentId);
		
		Date current_date = new Date(); //record an entry to an audit log every time a Student object is created or removed from the system
		SimpleDateFormat date_formatted = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
		String transaction_date = date_formatted.format(current_date);
		
		student_deleted.getTransactionRecord().add(transaction_date);
		
		
		return student_deleted ;
		
		
	}
	
	

}
