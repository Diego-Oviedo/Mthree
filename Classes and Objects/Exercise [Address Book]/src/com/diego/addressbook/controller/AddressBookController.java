package com.diego.addressbook.controller;
import java.util.List;
import com.diego.addressbook.model.dao.AddressBookDAO;
import com.diego.addressbook.model.dao.AddressBookDAOImpl;
import com.diego.addressbook.model.dao.AddressBookExceptionDAO;
import com.diego.addressbook.model.dto.Contact;
import com.diego.addressbook.view.ui.AddressBookView;



public class AddressBookController {
	
	private AddressBookDAOImpl dao;
	private AddressBookView view;
	
	public AddressBookController(AddressBookDAOImpl dao, AddressBookView view) {
		super();
		this.dao = dao;
		this.view = view;
	}
	
	
	public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                	getlistOfContacts();
                    break;
                case 2:
                	createContact();
                    break; 
                case 3:
                	viewContact();
                    break;
                case 4:
                	removeContact();
                    break;
                case 5:
                	updateContact();
                    break;    
                case 6:
                    keepGoing = false;
                    exitMessage();
                    break;
                default:
                	unknownCommand();
            }

        }
        exitMessage();
	    } catch (AddressBookExceptionDAO e) {
	        view.displayErrorMessage(e.getMessage());
	    }
    }

	private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
	
	private void getlistOfContacts() throws AddressBookExceptionDAO {
		view.displayDevider();
		view.displayAllContactsBanner();
		List<Contact> contacts = dao.retreiveAllContacts();
		view.displayContactList(contacts);
		view.displayDevider();
    }
	
	private void createContact() throws AddressBookExceptionDAO {
		view.displayDevider();
		view.displayCreateContactBanner();
		Contact contact = view.getNewContactInfo();
		dao.addContact(contact.getFirstName()+contact.getLastName(), contact);
		view.displayCreateSuccessBanner();
		view.displayDevider();
	}
	
	private void viewContact() throws AddressBookExceptionDAO {
		view.displayDevider();
		view.displayContactsBanner();
		String fullName = view.getContactFullName();
		Contact contact = dao.findContactByfullName(fullName);
		if(contact != null) {
		view.displayContactsBanner();
		view.displayContact(contact);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownContact();
			view.displayDevider();
		}
		
	}
	
	private void removeContact() throws AddressBookExceptionDAO {
		view.displayDevider();
		view.displayRemoveContactBanner();
		String fullName = view.getContactFullName();
		Contact contact = dao.findContactByfullName(fullName);
		if(contact != null) {
		Contact contact_removed = dao.removeContact(contact.getLastName());
		view.displayRemoveResult(contact_removed);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownContact();
			view.displayDevider();
		}
	}
	
	private void updateContact() throws AddressBookExceptionDAO {
		view.displayDevider();
		view.displayUpdateContactsBanner();
		String fullName = view.getContactFullName();
		Contact contact = dao.findContactByfullName(fullName);
		if(contact != null) {
		Contact new_contact = view.getContactInfoToUpdate(contact);
		dao.updateContact(fullName,new_contact);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownContact();
			view.displayDevider();
		}
	}
	
	private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
