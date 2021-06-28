package com.sg.classroster.controller;
import java.util.List;

import com.sg.classroster.dao.*;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.*;

public class ClassRosterController {
	
	private ClassRosterDao dao;//dependency
	private ClassRosterView view;//dependency
	
	public ClassRosterController(ClassRosterDao dao , ClassRosterView view) {//injecting dependencies view and dao
		this.dao = dao;
		this.view = view;
	}
	
	//private ClassRosterView view = new ClassRosterView();
	//private classRosterDao dao = new RosterDaoFileImpl();
    //private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                	listStudents();
                    break;
                case 2:
                	createStudent();
                    break;
                case 3:
                	viewStudent();
                    break;
                case 4:
                	removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    exitMessage();
                    break;
                default:
                	unknownCommand();
            }

        }
        exitMessage();
	    } catch (ClassRosterPersistenceException e) {
	        view.displayErrorMessage(e.getMessage());
	    }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void listStudents() throws ClassRosterPersistenceException {
    	List<Student> students = dao.getAllStudents();
    	view.displayDisplayAllBanner();
        view.displayStudentList(students);
    }
    
    private void createStudent() throws ClassRosterPersistenceException {
    	view.displayCreateStudentBanner();
        Student student = view.getNewStudentInfo();
        dao.addStudent(student.getStudentId(), student);
        view.displayCreateSuccessBanner();
    }
    
    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterPersistenceException {
    	String studentId = view.getStudentIdChoice();
    	Student removedStudent = dao.removeStudent(studentId);
    	view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}