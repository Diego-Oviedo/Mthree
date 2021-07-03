package com.diego.DVDLibrary.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.diego.DVDLibrary.dao.*;
import com.diego.DVDLibrary.dto.Item;
import com.diego.DVDLibrary.view.ui.DVDLibraryView;

@Component("controller")
public class DVDLibraryController {
	
	@Autowired
	@Qualifier("dao")
	private DVDLibraryDAO dao;
	@Autowired
	private DVDLibraryView view;
	
	/*public DVDLibraryController(DVDLibraryDAO dao, DVDLibraryView view) {
		super();
		this.dao = dao;
		this.view = view;
	}*/
	
	public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                	getlistOfDVDs();
                    break;
                case 2:
                	addDVD();
                    break; 
                case 3:
                	getDVD();
                    break;
                case 4:
                	removeDVD();
                    break;
                case 5:
                	updateDVD();
                    break; 
                case 6:
                	getDVDsByYear();
                    break; 
                case 7:
                	getDVDsByMPAARating();
                    break; 
                case 8:
                	getDVDsByDirector();
                    break; 
                case 9:
                	getDVDsByStudio();
                    break; 
                case 10:
                	getDVDsAveragePerYear();
                    break; 
                case 11:
                	getNewestDVD();
                    break; 
                case 12:
                	getOldestDVD();
                    break; 
                case 13:
                	getDVDsAveragePerNotes();
                    break; 
                case 14:
                    keepGoing = false;
                    exitMessage();
                    break;
                default:
                	unknownCommand();
            }

        }
 
	    } catch (DVDLibraryExceptionDAO e) {
	        view.displayErrorMessage(e.getMessage());
	    }
    }

	private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
	
	private void getlistOfDVDs() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayDVDListBanner();
		view.displayDVDsLoaded(dao.retreiveNumDVDs());
		List<Item> DVDs = dao.retreiveAllDVDs();
		view.displayDVDList(DVDs);
		view.displayDevider();
    }
	
	private void addDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayAddADVDBanner();
		Item DVD = view.getNewDVDInfo();
		dao.addDVD(DVD.getSKU(), DVD);
		view.displayCreateSuccessBanner();
		view.displayDevider();
	}
	
	private void getDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayFindDVDBanner();
		String title = view.getDVDTitle();
		Item DVD = dao.findDVDByTitle(title);
		if(DVD != null) {
		view.displayDVDBanner();
		view.displayDVD(DVD);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
		
	}
	
	private void removeDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayRemoveDVDBanner();
		String title = view.getDVDTitle();
		Item DVD = dao.findDVDByTitle(title);
		if(DVD != null) {
			Item DVD_removed = dao.removeDVD(DVD.getSKU());
		view.displayRemoveResult(DVD_removed);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	}
	
	private void updateDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayUpdateDVDBanner();
		String title = view.getDVDTitle();
		Item DVD = dao.findDVDByTitle(title);
		if(DVD != null) {
			Item new_DVD = view.getDVDInfoToUpdate(DVD);
		dao.updateDVD(DVD.getSKU(),new_DVD);
		view.displayUpdateSuccessBanner();
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	}
	
	private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void getDVDsByYear() throws DVDLibraryExceptionDAO {
    	view.displayDevider();
    	view.displayFindDVDsReleasedInTheLastNYearsBanner();
    	int year = view.displayGetNyear();
    	List <Item> dvds_filttered = dao.retreiveDVDsFromTheLastGivenYears(year);
    	if(dvds_filttered != Collections.EMPTY_LIST) {
    		view.displayDVDList(dvds_filttered);
    		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
    }
    
   private void getDVDsByMPAARating() throws DVDLibraryExceptionDAO {
	   view.displayDevider();
	   view.displayFindDVDsByMPAARatingBanner();
	   double mppa = view.displayGetMPAARating();
	   List <Item> dvds_filttered = dao.retreiveDVDsbyMPAARating(mppa);
	   if(dvds_filttered != Collections.EMPTY_LIST) {
   		view.displayDVDList(dvds_filttered);
   		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	   
   }
   private void getDVDsByDirector() throws DVDLibraryExceptionDAO {
	   view.displayDevider();
	   view.displayFindDVDByDirectorBanner();
	   String director = view.displayGetDirector();
	   List <Item> dvds_filttered = dao.retreiveDVDsbyDirector(director);
	   if(dvds_filttered != Collections.EMPTY_LIST) {
   		view.displayDVDList(dvds_filttered);
   		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	   
   }
   private void getDVDsByStudio() throws DVDLibraryExceptionDAO {
	   view.displayDevider();
	   view.displayFindDVDByStudioBanner();
	   String studio = view.displayGetStudio();
	   List <Item> dvds_filttered = dao.retreiveDVDsbyStudio(studio);
	   if(dvds_filttered != Collections.EMPTY_LIST) {
   		view.displayDVDList(dvds_filttered);
   		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	   
   }
   
   private void getDVDsAveragePerYear() throws DVDLibraryExceptionDAO {
	   view.displayDevider();
	   view.displayDVDsAveragePerYearBanner();
	   int average_year = dao.getDVDsAverageOfYear();
	   if(average_year != 0) {
   		view.displayAverage(average_year);
   		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	   
   }
   
   private void getNewestDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayFindNewestDVDBanner();
		Item DVD = dao.findNewestDVD();
		if(DVD != null) {
		view.displayDVDBanner();
		view.displayDVD(DVD);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
		
	}
   
   private void getOldestDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayFindOldestDVDBanner();
		Item DVD = dao.findOldestDVD();
		if(DVD != null) {
		view.displayDVDBanner();
		view.displayDVD(DVD);
		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
		
	}
   
   private void getDVDsAveragePerNotes() throws DVDLibraryExceptionDAO {
	   view.displayDevider();
	   view.displayDVDsAverageNotesPerMovieBanner();
	   int average_note = dao.getDVDsAverageNotesPerMovie();
	   if(average_note != 0) {
   		view.displayAverage(average_note);
   		view.displayDevider();
		}else {
			view.displayDevider();
			view.displayUnknownDVD();
			view.displayDevider();
		}
	   
   }

}
