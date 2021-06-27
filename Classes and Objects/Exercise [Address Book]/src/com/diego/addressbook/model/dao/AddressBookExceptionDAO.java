package com.diego.addressbook.model.dao;

public class AddressBookExceptionDAO extends Exception{

	public AddressBookExceptionDAO(String message) {
        super(message);
    }
    
    public AddressBookExceptionDAO(String message, Throwable cause) {
        super(message, cause);
    }
	
}
