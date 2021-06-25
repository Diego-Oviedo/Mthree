package com.sg.classroster;
import com.sg.classroster.controller.*;
import com.sg.classroster.ui.*;
import com.sg.classroster.dao.*;

public class App {

	public static void main(String[] args) {
		
		UserIO io = new UserIOConsoleImpl();//Instancing classes for dependencies,a s this is a job for the app initializer 
		ClassRosterView view = new ClassRosterView(io);//passing the instace of the class as parameter, so the dep. injection will react based on what we pass 
		ClassRosterDao dao = new RosterDaoFileImpl();
		
        ClassRosterController controller = new ClassRosterController(dao,view);
        controller.run();
    }   
	
}
