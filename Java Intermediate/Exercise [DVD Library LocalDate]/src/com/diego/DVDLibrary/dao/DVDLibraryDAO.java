package com.diego.DVDLibrary.dao;

import java.util.List;

import com.diego.DVDLibrary.dto.DVD;

public interface DVDLibraryDAO {

	public DVD addDVD(String SKU, DVD dvd) throws DVDLibraryExceptionDAO;
	
	public DVD removeDVD(String SKU) throws DVDLibraryExceptionDAO;
	
	public int retreiveNumDVDs() throws DVDLibraryExceptionDAO;
	
	public List<DVD> retreiveAllDVDs() throws DVDLibraryExceptionDAO;

	public DVD findDVDByTitle (String title) throws DVDLibraryExceptionDAO;
	
	public DVD updateDVD (String SKU,DVD dvd) throws DVDLibraryExceptionDAO;
	
	
}
