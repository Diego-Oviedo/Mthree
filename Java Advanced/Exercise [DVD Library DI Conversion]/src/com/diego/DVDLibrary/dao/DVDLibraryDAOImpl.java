	package com.diego.DVDLibrary.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.diego.DVDLibrary.dto.DVD;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Component("dao")
public class DVDLibraryDAOImpl implements DVDLibraryDAO {
	
	public final String FILE_PATH;
	

	public static final String DELIMITER = "::";
	
	private Map<String, DVD> DVDs = new HashMap<>();
	

	public DVDLibraryDAOImpl() {
		super();
		FILE_PATH = "DVDLibrary_data.txt";
	}
	
	public DVDLibraryDAOImpl(String fILE_PATH) {
		super();
		FILE_PATH = fILE_PATH;
	}
	

	@Override
	public DVD addDVD(String SKU, DVD dvd) throws DVDLibraryExceptionDAO {
		DVD DVD = DVDs.put(SKU, dvd);
		writeDVD();
		return DVD;
	}

	@Override
	public DVD removeDVD(String SKU) throws DVDLibraryExceptionDAO {
		loadData();
		DVD DVD = DVDs.remove(SKU);
		writeDVD();
		return DVD;
	}

	@Override
	public int retreiveNumDVDs() throws DVDLibraryExceptionDAO {
		retreiveAllDVDs();
		return DVDs.size();
	}

	@Override
	public List<DVD> retreiveAllDVDs() throws DVDLibraryExceptionDAO {
		loadData();
		return new ArrayList(DVDs.values());
	}

	@Override
	public DVD findDVDByTitle(String title) throws DVDLibraryExceptionDAO {
		loadData();
		
		DVD DVD = null;
		
		List<DVD> DVDs = retreiveAllDVDs();
		 
		for (DVD current_DVD : DVDs) {
			
			if(current_DVD.getTitle().equalsIgnoreCase(title)) {
				DVD = current_DVD;
			}

		}

		return DVD;
	}

	@Override
	public DVD updateDVD(String SKU, DVD dvd) throws DVDLibraryExceptionDAO {
		DVD DVD_deleted = removeDVD(SKU);
		
		String new_SKU = (dvd.getTitle().substring(0, 2).toUpperCase() + dvd.getStudio().substring(0, 2).toUpperCase() + 00 + "" + dvd.getRelease_date().getYear());
		
		dvd.setSKU(new_SKU);
		
		DVD DVD_updated = addDVD(dvd.getSKU(), dvd);
		
		return DVD_updated;
	}
	
	
	//UTILITY METHODS 

	private void loadData() throws DVDLibraryExceptionDAO{
		   
		Scanner reader;
		 
	    try {
	        
	    	File file = new File(FILE_PATH);
		      reader = new Scanner(file);
		      reader.useDelimiter(DELIMITER);
	    } catch (FileNotFoundException e) {
	        throw new DVDLibraryExceptionDAO(
	                "Could not load data into memory.", e);
	    }
	    
	    String currentLine;
	    String SKU;
	    
	    DVD currentDVD;
	    	    
	    while (reader.hasNextLine()) {//while there is data to persist
	        
	        currentLine = reader.nextLine();

	        currentDVD = unmarshallObject(currentLine); //Convert a line into an object 
	        
	        SKU = (currentDVD.getTitle().substring(0, 2).toUpperCase() + currentDVD.getStudio().substring(0, 2).toUpperCase() + 00 + "" + currentDVD.getRelease_date().getYear());
	        
	        currentDVD.setSKU(SKU);
	        
	        DVDs.put(currentDVD.getSKU(), currentDVD);//put the object into the HashMap 

	    }
	    
	    reader.close();//once done, close the reader
	}
	
	
	private DVD unmarshallObject(String objectAsText){
		
		String[] objectTokens = objectAsText.split(DELIMITER);//the split method will return an array of string  with every piece of data in each element 
		
		 
		String SKU = (objectTokens[0].substring(0, 2).toUpperCase() + objectTokens[4].substring(0, 2).toUpperCase() + 00 + "" + objectTokens[1]);
        
		DVD DVD = new DVD(SKU);
		
		DVD.setTitle(objectTokens[0]);
		
		DVD.setRelease_date(DVD.yearToDateFormatter(objectTokens[1]));

		DVD.setMPAA_rating(Double.valueOf(objectTokens[2]));
		
		DVD.setAuthor(objectTokens[3]);
		
		DVD.setStudio(objectTokens[4]);
		
		DVD.setUser_note(objectTokens[5]);
		
	    return DVD;
	}
	
	private String marshallObject(DVD DVD){
		String DVDAsText = DVD.getTitle() + DELIMITER; 
		DVDAsText += DVD.getRelease_date().getYear()+ DELIMITER;
		DVDAsText += DVD.getMPAA_rating() + DELIMITER;
		DVDAsText += DVD.getAuthor() + DELIMITER;
		DVDAsText += DVD.getStudio() + DELIMITER;
		DVDAsText += DVD.getUser_note();
		
		return DVDAsText;
	}
	
	private void writeDVD() throws DVDLibraryExceptionDAO { 
		PrintWriter out;
		
		try {
	        out = new PrintWriter(new FileWriter(FILE_PATH));
	    } catch (IOException e) {
	        throw new DVDLibraryExceptionDAO(
	                "Could not save student data.", e);
	    }
		
		String DVDAsText;
	    List<DVD> DVDs = this.retreiveAllDVDs();
	    for (DVD DVD : DVDs) {
	        
	    	DVDAsText = marshallObject(DVD);
	        // write the object to the file
	        out.println(DVDAsText);
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
		
	}

	@Override
	public List<DVD> retreiveDVDsFromTheLastGivenYears(int numberOfYearsBack) throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		LocalDate date_calculated = LocalDate.now();
		
		int year = date_calculated.minusYears(numberOfYearsBack).getYear();
		
		return dvds.stream().filter((dvd) -> dvd.getRelease_date().getYear() >= year).collect(Collectors.toList());
	}

	@Override
	public List<DVD> retreiveDVDsbyMPAARating(double rating) throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		return dvds.stream().filter((dvd) -> dvd.getMPAA_rating() == rating).collect(Collectors.toList());
	}

	@Override
	public List<DVD> retreiveDVDsbyDirector(String director) throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		return dvds.stream().filter((dvd) -> dvd.getAuthor().toLowerCase().contains(director.toLowerCase())).collect(Collectors.toList());
	}

	@Override
	public List<DVD> retreiveDVDsbyStudio(String studio) throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		return dvds.stream().filter((dvd) -> dvd.getStudio().toLowerCase().contains(studio.toLowerCase())).collect(Collectors.toList());
	}

	@Override
	public int getDVDsAverageOfYear() throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		OptionalDouble average = dvds.stream().mapToInt((dvd) -> dvd.getRelease_date().getYear()).average();
		
		String average_string = String.valueOf(average)+"";
		
		average_string = average_string.substring(15,19);
		
		System.out.println("Sting value of average_string : " + average_string);
		
		int actual_average = Integer.valueOf(average_string);
		
		return actual_average;
	}

	@Override
	public DVD findNewestDVD() throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		List<DVD> result = dvds.stream().sorted((o1, o2)->  String.valueOf(o1.getRelease_date().getYear()).
                compareTo(String.valueOf(o1.getRelease_date().getYear()))).
                collect(Collectors.toList());
		
		return result.get((result.size()-1));
	}

	@Override
	public DVD findOldestDVD() throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		List<DVD> result = dvds.stream().sorted((o1, o2)->  String.valueOf(o1.getRelease_date().getYear()).
                compareTo(String.valueOf(o1.getRelease_date().getYear()))).
                collect(Collectors.toList());
		
		return result.get(0);
	}

	@Override
	public int getDVDsAverageNotesPerMovie() throws DVDLibraryExceptionDAO {
		List<DVD> dvds = retreiveAllDVDs();
		
		int dvds_w_notes =dvds.stream()
        		.filter((dvd) -> dvd.getUser_note() != null ).collect(Collectors.toList()).size();
		
		
		int average = dvds_w_notes / dvds.size();
		
		return average;
	}

}
