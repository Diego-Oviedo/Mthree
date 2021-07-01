package com.sg.classroster;
import com.sg.classroster.controller.*;
import com.sg.classroster.ui.*;
import com.sg.classroster.dao.*;
import com.sg.classroster.service.*;

public class App {

	public static void main(String[] args) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException {
		
		UserIO io = new UserIOConsoleImpl();// Instantiate the UserIO implementation
		ClassRosterView view = new ClassRosterView(io);// Instantiate the View and wire the UserIO implementation into it 
		ClassRosterDAO dao = new RosterDaoFileImpl(); // Instantiate the DAO
		ClassRosterAuditDao dao_audit = new ClassRosterAuditDaoFileImpl();// Instantiate the Audit DAO
		ClassRosterService service = new ClassRosterServiceImpl(dao,dao_audit);// Instantiate the Service Layer and wire the DAO and Audit DAO into it
		
        ClassRosterController controller = new ClassRosterController(service,view); // Instantiate the Controller and wire the Service Layer into it
        controller.run();
    }   
	
}
