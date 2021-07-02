package com.diego.DVDLibrary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.diego.DVDLibrary.controller.DVDLibraryController;
import com.diego.DVDLibrary.dao.*;
import com.diego.DVDLibrary.view.ui.*;

public class App {

	public static void main(String[] args) {
		
		/*UserIO io = new UserIOImpl();
		DVDLibraryView view = new DVDLibraryView(io);
		DVDLibraryDAO dao = new DVDLibraryDAOImpl();

		DVDLibraryController app = new DVDLibraryController(dao,view);
		
		app.run();*/
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.diego.DVDLibrary");
		context.refresh();
		
		DVDLibraryController controller = context.getBean("controller" , DVDLibraryController.class);
		
		controller.run();
		
	}

}
