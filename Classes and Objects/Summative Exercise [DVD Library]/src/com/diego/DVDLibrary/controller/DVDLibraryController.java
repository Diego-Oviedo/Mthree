package com.diego.DVDLibrary.controller;

import java.util.List;

import com.diego.DVDLibrary.dao.*;
import com.diego.DVDLibrary.dto.DVD;
import com.diego.DVDLibrary.view.ui.DVDLibraryView;

public class DVDLibraryController {
	
	private DVDLibraryDAO dao;
	private DVDLibraryView view;
	
	public DVDLibraryController(DVDLibraryDAO dao, DVDLibraryView view) {
		super();
		this.dao = dao;
		this.view = view;
	}
	
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
		List<DVD> DVDs = dao.retreiveAllDVDs();
		view.displayDVDList(DVDs);
		view.displayDevider();
    }
	
	private void addDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayAddADVDBanner();
		DVD DVD = view.getNewDVDInfo();
		dao.addDVD(DVD.getSKU(), DVD);
		view.displayCreateSuccessBanner();
		view.displayDevider();
	}
	
	private void getDVD() throws DVDLibraryExceptionDAO {
		view.displayDevider();
		view.displayFindDVDBanner();
		String title = view.getDVDTitle();
		DVD DVD = dao.findDVDByTitle(title);
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
		DVD DVD = dao.findDVDByTitle(title);
		if(DVD != null) {
			DVD DVD_removed = dao.removeDVD(DVD.getSKU());
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
		DVD DVD = dao.findDVDByTitle(title);
		if(DVD != null) {
			DVD new_DVD = view.getDVDInfoToUpdate(DVD);
		dao.updateContact(new_DVD.getSKU(),new_DVD);
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

}
