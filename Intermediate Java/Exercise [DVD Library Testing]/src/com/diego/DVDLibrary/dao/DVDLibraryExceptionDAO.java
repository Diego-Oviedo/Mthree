package com.diego.DVDLibrary.dao;

public class DVDLibraryExceptionDAO extends Exception{

	public DVDLibraryExceptionDAO(String message) {
        super(message);
    }
    
    public DVDLibraryExceptionDAO(String message, Throwable cause) {
        super(message, cause);
    }
	
}
