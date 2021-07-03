package com.diego.DVDLibrary.dao;

import java.util.List;

import com.diego.DVDLibrary.dto.Item;

public interface DVDLibraryDAO {

	public Item addDVD(String SKU, Item dvd) throws DVDLibraryExceptionDAO;
	
	public Item removeDVD(String SKU) throws DVDLibraryExceptionDAO;
	
	public int retreiveNumDVDs() throws DVDLibraryExceptionDAO;
	
	public List<Item> retreiveAllDVDs() throws DVDLibraryExceptionDAO;

	public Item findDVDByTitle (String title) throws DVDLibraryExceptionDAO;
	
	public Item updateDVD (String SKU,Item dvd) throws DVDLibraryExceptionDAO;
	
	public List<Item> retreiveDVDsFromTheLastGivenYears(int numberOfYearsBack) throws DVDLibraryExceptionDAO;//Find all movies released in the last N years
	
	public List<Item> retreiveDVDsbyMPAARating(double rating) throws DVDLibraryExceptionDAO;//Find all the movies with a given MPAA rating
	
	public List<Item> retreiveDVDsbyDirector(String director) throws DVDLibraryExceptionDAO;//Find all the movies by a given director, the movies should be sorted into separate data structures by MPAA rating.
	
	public List<Item> retreiveDVDsbyStudio(String studio) throws DVDLibraryExceptionDAO;//Find all the movies released by a particular studio
	
	public int getDVDsAverageOfYear() throws DVDLibraryExceptionDAO;//Find the average age of the movies in the collection
	
	public Item findNewestDVD () throws DVDLibraryExceptionDAO;//Find the newest movie in your collection
	
	public Item findOldestDVD () throws DVDLibraryExceptionDAO;//Find the oldest movie in your collection
	
	public int getDVDsAverageNotesPerMovie() throws DVDLibraryExceptionDAO; //Find the average number of notes associated with movies in your collection
}
