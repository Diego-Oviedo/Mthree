package com.sg.classroster.dao;
import com.sg.classroster.dto.*;
import java.util.*;

public interface classRosterDao {

	Student addStudent(String studentId, Student student);
	
	List<Student> getAllStudents();
	
	Student getStudent(String studentId);
	
	Student removeStudent(String studentId);

}
