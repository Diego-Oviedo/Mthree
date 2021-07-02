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
	
	public List<DVD> retreiveDVDsFromTheLastGivenYears(int numberOfYearsBack) throws DVDLibraryExceptionDAO;//Find all movies released in the last N years
	
	public List<DVD> retreiveDVDsbyMPAARating(double rating) throws DVDLibraryExceptionDAO;//Find all the movies with a given MPAA rating
	
	public List<DVD> retreiveDVDsbyDirector(String director) throws DVDLibraryExceptionDAO;//Find all the movies by a given director, the movies should be sorted into separate data structures by MPAA rating.
	
	public List<DVD> retreiveDVDsbyStudio(String studio) throws DVDLibraryExceptionDAO;//Find all the movies released by a particular studio
	
	public int getDVDsAverageOfYear() throws DVDLibraryExceptionDAO;//Find the average age of the movies in the collection
	
	public DVD findNewestDVD () throws DVDLibraryExceptionDAO;//Find the newest movie in your collection
	
	public DVD findOldestDVD () throws DVDLibraryExceptionDAO;//Find the oldest movie in your collection
	
	public int getDVDsAverageNotesPerMovie() throws DVDLibraryExceptionDAO; //Find the average number of notes associated with movies in your collection
}
