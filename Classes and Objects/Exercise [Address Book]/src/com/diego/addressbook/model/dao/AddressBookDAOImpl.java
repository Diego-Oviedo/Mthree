package com.diego.addressbook.model.dao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.diego.addressbook.model.dto.*;


public class AddressBookDAOImpl implements AddressBookDAO {

	public static final String FILE_PATH = "AddressBook_data.txt";
	public static final String DELIMITER = "::";
	
	private Map<String, Contact> contacts = new HashMap<>();
	
	@Override
	public Contact addContact(String fullName, Contact contac) throws AddressBookExceptionDAO{
		Contact contact = contacts.put(fullName, contac);
		writeContact();
		return contact;
	}

	@Override
	public Contact removeContact(String fullName) throws AddressBookExceptionDAO{
		loadData();
		Contact contact = contacts.remove(fullName);
		writeContact();
		return contact;
	}

	@Override
	public int retreiveNumContacts() throws AddressBookExceptionDAO{
		retreiveAllContacts();
		return contacts.size();
	}

	@Override
	public List<Contact> retreiveAllContacts() throws AddressBookExceptionDAO{
		loadData();
		return new ArrayList(contacts.values());
	}

	@Override
	public Contact findContactByfullName(String fullName) throws AddressBookExceptionDAO{
		loadData();
		 
		Set <String> keys = contacts.keySet();
		Contact contact = null;

			contact = contacts.get(fullName);

		return contact;
	}
		
	@Override
	public Contact updateContact(String fullName,Contact new_contact) throws AddressBookExceptionDAO{
		loadData();
		contacts.remove(fullName);
		Contact contact_updated = contacts.put(new_contact.getFirstName()+new_contact.getLastName(), new_contact);
		return contact_updated;
	}
	
	//UTILITY METHODS 
	
	private void loadData() throws AddressBookExceptionDAO{
		   
		Scanner reader;
		 
	    try {
	        
	    	File file = new File(FILE_PATH);
		      reader = new Scanner(file);
		      reader.useDelimiter(DELIMITER);
	    } catch (FileNotFoundException e) {
	        throw new AddressBookExceptionDAO(
	                "Could not load data into memory.", e);
	    }
	    
	    String currentLine;
	    
	    Contact currentContact;
	    	    
	    while (reader.hasNextLine()) {//while there is data to persist
	        
	        currentLine = reader.nextLine();

	        currentContact = unmarshallObject(currentLine); //Convert a line into an object 
	        
	        contacts.put(currentContact.getFirstName()+currentContact.getLastName(), currentContact);//put the object into the HashMap 
	    }
	    
	    reader.close();//once done, close the reader
	}
	
	
	private Contact unmarshallObject(String objectAsText){
		String[] objectTokens = objectAsText.split(DELIMITER);//the split method will return an array of string  with every piece of data in each element 
		
		 
		String fullName ="" + objectTokens[0] + objectTokens[1];
		 
		Contact contact = new Contact(fullName);
		
		contact.setFirstName(objectTokens[0]);
		
		contact.setLastName(objectTokens[1]);

		contact.setStreetAddress(objectTokens[2]);
		
		contact.setProvince(objectTokens[3]);
		
		contact.setPostalCode(objectTokens[4]);
		
	    return contact;
	}
	
	
	private String marshallObject(Contact contact){
		String contactAsText = contact.getFirstName() + DELIMITER; 
		contactAsText += contact.getLastName()+ DELIMITER;
		contactAsText += contact.getStreetAddress() + DELIMITER;
		contactAsText += contact.getProvince() + DELIMITER;
		contactAsText += contact.getPostalCode();
		
		return contactAsText;
	}
	
	private void writeContact() throws AddressBookExceptionDAO { 
		PrintWriter out;
		
		try {
	        out = new PrintWriter(new FileWriter(FILE_PATH));
	    } catch (IOException e) {
	        throw new AddressBookExceptionDAO(
	                "Could not save student data.", e);
	    }
		
		String contactAsText;
	    List<Contact> contacts = this.retreiveAllContacts();
	    for (Contact contact : contacts) {
	        
	    	contactAsText = marshallObject(contact);
	        // write the object to the file
	        out.println(contactAsText);
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
		
	}
	
	

}
