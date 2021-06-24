package com.sg.classroster.controller;
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
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    view.displayCreateStudentBanner();
                    Student student = view.getNewStudentInfo();
                    dao.addStudent(student.getStudentId(), student);
                    view.displayCreateSuccessBanner();
                    break;
                case 3:
                    io.print("VIEW STUDENT");
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
}