package com.sg.classroster.service;

import java.util.*;

import com.sg.classroster.dao.*;
import com.sg.classroster.dto.Student;
import java.text.SimpleDateFormat;

public class ClassRosterServiceImpl implements ClassRosterService {
	
	private ClassRosterDAO dao;
	private ClassRosterAuditDao auditDao;

	public ClassRosterServiceImpl(ClassRosterDAO dao, ClassRosterAuditDao auditDao) {
		super();
		this.dao = dao;
		this.auditDao = auditDao;
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
		
		
		dao.addStudent(student.getStudentId(), student);
		
		auditDao.writeAuditEntry("Student: " +  student.getStudentId() + " Crated!!");
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
		

		auditDao.writeAuditEntry("Student: " +  studentId + " Removed!!");
		
		return student_deleted ;
		
		
	}
	
	

}
