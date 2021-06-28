package com.diego.addressbook.view.ui;
import java.util.List;
import com.diego.addressbook.model.dto.Contact;


public class AddressBookView {
	
	private UserIO io;//injecting the userIO dependency 
	
	public AddressBookView(UserIO io) {//injecting the userIO dependency 
		this.io =  io;
	}
	
	public int printMenuAndGetSelection() {//this method is being developed over the view module and implemented on the model controller module 
        io.print("------------------------------------------------------------\nMain Menu\n------------------------------------------------------------\n");
        io.print("1. List of contacts");
        io.print("2. Create new contact");
        io.print("3. View a contact");
        io.print("4. Remove a contact");
        io.print("5. Update a contact");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
	
	public void displayContactsLoaded(int contacts) {
        io.print("*** "+contacts+" Contacts in the Address Book ***");
    }
	
	public void displayCreateContactBanner() {
	        io.print("=== Create Contact ===");
	    }
	
	public void displayDevider() {
	 	io.print("\n____________________________________________________________________________________________\n");
    }
	
	 public Contact getNewContactInfo() {
	        String firstName = io.readString("Please enter First Name");
	        String lastName = io.readString("Please enter Last Name");
	        String streetAddress = io.readString("Please enter Street Address");
	        String province = io.readString("Please enter Province/state");
	        String postalCode = io.readString("Please enter Postal Code");
	        Contact currentContact = new Contact((firstName+lastName).toUpperCase());
	        currentContact.setFirstName(firstName);
	        currentContact.setLastName(lastName);
	        currentContact.setStreetAddress(streetAddress);
	        currentContact.setProvince(province);
	        currentContact.setPostalCode(postalCode);
	        return currentContact;
	    }
	 
	 public Contact getContactInfoToUpdate(Contact contact) {
		 String firstName =  null;
		 String lastName =  null;
		 String streetAddress = null;
		 String province = null;
		 String postalCode =  null;
		 
		 
		 	if(io.readString("Fisrt name: " + contact.getFirstName() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		firstName = io.readString("Please enter First Name: ");
		 	}else {
		 		firstName = contact.getFirstName();
		 	}
		 	
		 	if(io.readString("Last name: " + contact.getLastName() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		lastName = io.readString("Please enter Last Name: ");
		 	}else {
		 		lastName = contact.getLastName();
		 	}
		 	
		 	if(io.readString("Street Address: " + contact.getStreetAddress() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		streetAddress = io.readString("Please enter Street Address: ");
		 	}else {
		 		streetAddress = contact.getStreetAddress();
		 	}
		 	
		 	if(io.readString("Province: " + contact.getProvince() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		province = io.readString("Please enter Province: ");
		 	}else {
		 		province = contact.getProvince();
		 	}
	        
		 	if(io.readString("Postal Code: " + contact.getPostalCode() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		postalCode = io.readString("Please enter Postal Code: ");
		 	}else {
		 		postalCode = contact.getPostalCode();
		 	}
		 	

	        Contact contact_to_update = new Contact((firstName+lastName).toUpperCase());
	        contact_to_update.setFirstName(firstName);
	        contact_to_update.setLastName(lastName);
	        contact_to_update.setStreetAddress(streetAddress);
	        contact_to_update.setProvince(province);
	        contact_to_update.setPostalCode(postalCode);
	        
	        return contact_to_update;
	    }
	 
	     
	   public void displayCreateSuccessBanner() {
	        io.readString(
	                "Contact successfully created.\nPlease hit 0 and enter to continue");
	    }
	   
	   public void displayUpdateSuccessBanner() {
	        io.readString(
	                "Contact successfully updated.\nPlease hit 0 and enter to continue");
	    }
	   
	   public String getContactFullName() {
	        return io.readString("Please enter the contact's full name (first name + last name) with NO spaces in between.");
	    }

	   public void displayDeleteContactBanner() {
		        io.print("=== Delete Contact ===");
		    }
	    
	    public void displayRemoveResult(Contact contact) {
	        io.readString("Contact was successfully removed.\nPlease hit 0 and enter to continue");
	    }
	    
	    public void displayContactsBanner() {
	        io.print("=== View Contact ===");
	    }
	    
	    public void displayUpdateContactsBanner() {
	        io.print("=== Edit Contact ===");
	    }
	    
	    public void displayRemoveContactBanner() {
	        io.print("=== Remove Contact ===");
	    }
	    
	    public void displayAllContactsBanner() {
	        io.print("=== All Contacts ===");
	    }
	    
	    public void displayContactList(List<Contact> contactList) {
	        for (Contact currentContact : contactList) {
	            String contactInfo = String.format("%s %s : %s %s %s",
	                  currentContact.getFirstName(),
	                  currentContact.getLastName(),
	                  currentContact.getStreetAddress(),
	                  currentContact.getProvince(),
	                  currentContact.getPostalCode());
	            io.print(contactInfo);
	        }
	        io.readString("Please hit 0 and enter to continue.");
	    }

	    
	    public void displayContact(Contact contact) {
	        if (contact != null) { 
	        	String contactInfo = String.format("%s %s : %s %s %s",
	        			contact.getLastName(),
	        			contact.getFirstName(),
	        			contact.getStreetAddress(),
	        			contact.getProvince(),
	        			contact.getPostalCode()); 
	        	
	        	 io.print(contactInfo);
	        } else {
	            io.print("No such a contact.");
	        }
	        io.readString("Please hit 0 and enter to continue.");
	    }
	    
	    
	    public void displayErrorMessage(String errorMsg) {
	        io.print("=== ERROR ===");
	        io.print(errorMsg);
	    }
	    
	    public void displayExitBanner() {
	        io.print("Good Bye!!!");
	    }
	    
	    public void displayUnknownContact() {
	        io.print("Contact not registered!!!");
	    }

	    public void displayUnknownCommandBanner() {
	        io.print("Unknown Command!!!");
	    }

}
