package com.diego.addressbook;

import com.diego.addressbook.controller.AddressBookController;
import com.diego.addressbook.model.dao.AddressBookDAOImpl;
import com.diego.addressbook.view.ui.*;

public class App {

	public static void main(String[] args) {
		UserIO io = new UserIOImpl();
		AddressBookView view = new AddressBookView(io);
		AddressBookDAOImpl dao = new AddressBookDAOImpl();

		AddressBookController app = new AddressBookController(dao,view);
		
		app.run();
		 
	}

}
