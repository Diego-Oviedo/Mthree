package com.diego.addressbook.model.dao;
import com.diego.addressbook.model.dto.*;
import java.util.*;

public interface AddressBookDAO {

	public Contact addContact(String fullName, Contact contac) throws AddressBookExceptionDAO;
	
	public Contact removeContact(String fullName) throws AddressBookExceptionDAO;
	
	public int retreiveNumContacts() throws AddressBookExceptionDAO;
	
	public List<Contact> retreiveAllContacts() throws AddressBookExceptionDAO;

	public Contact findContactByfullName (String fullName) throws AddressBookExceptionDAO;
	
	public Contact updateContact (String fullName,Contact new_contact) throws AddressBookExceptionDAO;
	
}
