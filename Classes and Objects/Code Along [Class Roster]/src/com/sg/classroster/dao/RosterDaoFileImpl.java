package com.sg.classroster.dao;

import java.util.*;

import com.sg.classroster.dto.Student;

public class RosterDaoFileImpl implements classRosterDao {
	
	private Map<String, Student> students = new HashMap<>();

	@Override
    public Student addStudent(String studentId, Student student) {
		Student prevStudent = students.put(studentId, student);
	    return prevStudent;
	}

    @Override
    public List<Student> getAllStudents() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student getStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student removeStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
