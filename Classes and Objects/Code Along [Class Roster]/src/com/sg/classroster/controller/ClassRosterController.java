package com.sg.classroster.controller;
import java.util.List;

import com.sg.classroster.dao.*;
import com.sg.classroster.dto.Student;
import com.sg.classroster.ui.*;

public class ClassRosterController {

	private ClassRosterView view = new ClassRosterView();
	private classRosterDao dao = new RosterDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
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
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void listStudents() {
    	List<Student> students = dao.getAllStudents();
    	view.displayDisplayAllBanner();
        view.displayStudentList(students);
    }
    
    private void createStudent() {
    	view.displayCreateStudentBanner();
        Student student = view.getNewStudentInfo();
        dao.addStudent(student.getStudentId(), student);
        view.displayCreateSuccessBanner();
    }
    
    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
}