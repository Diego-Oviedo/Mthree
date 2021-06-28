package com.diego.DVDLibrary;

import com.diego.DVDLibrary.controller.DVDLibraryController;
import com.diego.DVDLibrary.dao.DVDLibraryDAOImpl;
import com.diego.DVDLibrary.view.ui.*;

public class App {

	public static void main(String[] args) {
		
		UserIO io = new UserIOImpl();
		DVDLibraryView view = new DVDLibraryView(io);
		DVDLibraryDAOImpl dao = new DVDLibraryDAOImpl();

		DVDLibraryController app = new DVDLibraryController(dao,view);
		
		app.run();
	}

}
