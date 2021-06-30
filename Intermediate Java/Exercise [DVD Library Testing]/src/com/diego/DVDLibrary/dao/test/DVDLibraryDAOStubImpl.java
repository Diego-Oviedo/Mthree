package com.diego.DVDLibrary.dao.test;

import java.util.ArrayList;
import java.util.List;

import com.diego.DVDLibrary.dao.*;
import com.diego.DVDLibrary.dto.*;

public class DVDLibraryDAOStubImpl implements DVDLibraryDAO{
	
	public DVD dvd_test;
	
	public DVDLibraryDAOStubImpl () {
		dvd_test.setSKU("0001");
		dvd_test.setTitle("Black Swan");
		dvd_test.setRelease_date("2020");
		dvd_test.setMPAA_rating(7.9);
		dvd_test.setAuthor("Michael Collins");
		dvd_test.setStudio("Marvel");
		dvd_test.setUser_note("N/A");	
	}

	public DVDLibraryDAOStubImpl(DVD dvd_test) {
		super();
		this.dvd_test = dvd_test;
	}

	@Override
	public DVD addDVD(String SKU, DVD dvd) throws DVDLibraryExceptionDAO {
		if (SKU.equals(dvd_test.getSKU())) {
            return dvd_test;
        } else {
            return null;
        }
	}

	@Override
	public DVD removeDVD(String SKU) throws DVDLibraryExceptionDAO {
		 if (SKU.equals(dvd_test.getSKU())) {
	            return dvd_test;
	        } else {
	            return null;
	        }
	}

	@Override
	public int retreiveNumDVDs() throws DVDLibraryExceptionDAO {
		return retreiveAllDVDs().size();
	}

	@Override
	public List<DVD> retreiveAllDVDs() throws DVDLibraryExceptionDAO {
		List<DVD> DVDList = new ArrayList<>();
		DVDList.add(dvd_test);
		return null;
	}

	@Override
	public DVD findDVDByTitle(String title) throws DVDLibraryExceptionDAO {
		if (title.equals(dvd_test.getTitle())) {
            return dvd_test;
        } else {
            return null;
        } 
	}

	@Override
	public DVD updateDVD(String SKU, DVD dvd) throws DVDLibraryExceptionDAO {
		if ( !dvd.getSKU().equals(dvd_test.getSKU())  && SKU.equals(dvd_test.getSKU()) ) {
            return dvd_test;
        }
		return null;
	}
	
	
}
