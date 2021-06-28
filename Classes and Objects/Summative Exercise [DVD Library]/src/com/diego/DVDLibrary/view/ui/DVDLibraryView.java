package com.diego.DVDLibrary.view.ui;

import java.util.List;

import com.diego.DVDLibrary.dto.DVD;

public class DVDLibraryView {
	
	private UserIO io;//injecting the userIO dependency 
	
	public DVDLibraryView(UserIO io) {//injecting the userIO dependency 
		this.io =  io;
	}
	
	
	public int printMenuAndGetSelection() {
        io.print("------------------------------------------------------------\nMain Menu\n------------------------------------------------------------\n");
        io.print("1. List of DVDs");
        io.print("2. Add a new DVD");
        io.print("3. Find the information of a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Update the information of a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
	
	public void displayDVDsLoaded(int dvds) {
        io.print("*** "+dvds+" DVDs in the Library ***");
    }
	
	public void displayAddADVDBanner() {
        io.print("=== Add a DVD ===");
    }
	
	public void displayDevider() {
	 	io.print("\n____________________________________________________________________________________________\n");
    }
	
	public DVD getNewDVDInfo() {
        String title = io.readString("Please enter Title:");
        String release_date = io.readString("Please enter Release date:");
        double MPAA_rating = io.readDouble("Please enter MPAA rating (e.g. 7.5):",1,10);
        String author = io.readString("Please enter Director's name:");
        String studio = io.readString("Please enter Studio:");
        String user_note = io.readString("Please enter Personal raiting or note ( e.g., \"Good family movie\"):");
        
        String SKU = (title.substring(0, 2).toUpperCase() + studio.substring(0, 2).toUpperCase() + 00 + "" + release_date);
        
        DVD currentDVD = new DVD(SKU);
        
        currentDVD.setSKU(SKU);
        currentDVD.setTitle(title);
        currentDVD.setRelease_date(release_date);
        currentDVD.setMPAA_rating(MPAA_rating);
        currentDVD.setAuthor(author);
        currentDVD.setStudio(studio);
        currentDVD.setUser_note(user_note);

        return currentDVD;
    }
	
	public DVD getDVDInfoToUpdate(DVD DVD) {
			String title = null;
	        String release_date = null;
	        double MPAA_rating = 0.0;
	        String author = null;
	        String studio = null;
	        String user_note = null;
        
		 
		 	if(io.readString("Title: " + DVD.getTitle() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		title = io.readString("Please enter Title: ");
		 	}else {
		 		title = DVD.getTitle();
		 	}
		 	
		 	if(io.readString("Release date: " + DVD.getRelease_date() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		release_date = io.readString("Please enter Release date: ");
		 	}else {
		 		release_date = DVD.getRelease_date();
		 	}
		 	
		 	if(io.readString("MPAA rating: " + DVD.getMPAA_rating() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		MPAA_rating = io.readDouble("Please enter MPAA rating (e.g. 7.5):",1,10);
		 	}else {
		 		MPAA_rating = DVD.getMPAA_rating();
		 	}
		 	
		 	if(io.readString("Author/Director's name: " + DVD.getAuthor() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		author = io.readString("Please enter Director's name:");
		 	}else {
		 		author = DVD.getAuthor();
		 	}
	        
		 	if(io.readString("Studio: " + DVD.getStudio() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		studio = io.readString("Please enter Studio: ");
		 	}else {
		 		studio = DVD.getStudio();
		 	}
		 	
		 	if(io.readString("Personal raiting or note: " + DVD.getUser_note() + " want to change it? (Y/N)").equalsIgnoreCase("y")) {
		 		user_note = io.readString("Please enter Personal raiting or note ( e.g., \"Good family movie\"):");
		 	}else {
		 		user_note = DVD.getUser_note();
		 	}
		 	
		 	String SKU = (title.substring(0, 2).toUpperCase() + studio.substring(0, 2).toUpperCase() + 00 + "" + release_date);

		 	DVD DVD_to_update = new DVD(SKU);
		 	
		 	DVD_to_update.setSKU(SKU);
		 	DVD_to_update.setTitle(title);
		 	DVD_to_update.setRelease_date(release_date);
		 	DVD_to_update.setMPAA_rating(MPAA_rating);
		 	DVD_to_update.setAuthor(author);
		 	DVD_to_update.setStudio(studio);
		 	DVD_to_update.setUser_note(user_note);
	        
	        return DVD_to_update;
	    }
	
	public void displayDVDList(List<DVD> DVDList) {
        for (DVD currentDVD : DVDList) {
            String DVDInfo = String.format("%s : %s %s %s %s %s %s",
                  "SKU: "+currentDVD.getSKU(),
                  "Title: "+currentDVD.getTitle()+"\n",
                  "Release date: "+currentDVD.getRelease_date()+"\n",
                  "MPAA rating: "+currentDVD.getMPAA_rating()+"\n",
                  "Director's name: "+currentDVD.getAuthor()+"\n",
                  "Studio: "+currentDVD.getStudio()+"\n",
                  "User rating or note: "+currentDVD.getUser_note()+"\n");
            io.print(DVDInfo);
        }
        io.readString("Please hit 0 and enter to continue.");
    }

    
    public void displayDVD(DVD DVD) {
        if (DVD != null) { 
        	String DVDInfo = String.format("%s : %s %s %s %s %s %s",
                    "SKU: "+DVD.getSKU(),
                    "Title: "+DVD.getTitle()+"\n",
                    "Release date: "+DVD.getRelease_date()+"\n",
                    "MPAA rating: "+DVD.getMPAA_rating()+"\n",
                    "Director's name: "+DVD.getAuthor()+"\n",
                    "Studio: "+DVD.getStudio()+"\n",
                    "User rating or note: "+DVD.getUser_note()+"\n");
        	
        	 io.print(DVDInfo);
        } else {
            io.print("No record found.");
        }
        io.readString("Please hit 0 and enter to continue.");
    }
	
	public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully added.\nPlease hit 0 and enter to continue");
    }
	
	public void displayUpdateSuccessBanner() {
        io.readString(
                "DVD successfully updated.\nPlease hit 0 and enter to continue");
    }
	
	public String getDVDTitle() {
        return io.readString("Please enter the DVD's title.");
    }
	
    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD from library ===");
    }
    
    public String getDVDSKU() {
        return io.readString("Please enter the DVD's SKU.");
    }
    
	public void displayRemoveResult(DVD dvd) {
        io.readString("DVD was successfully removed.\nPlease hit 0 and enter to continue");
    }
	
	public void displayDVDBanner() {
	        io.print("=== View DVD information ===");
    }
	 
	public void displayUpdateDVDBanner() {
        io.print("=== Update DVD information ===");
    }
    
    public void displayDVDListBanner() {
        io.print("=== DVDs in library ===");
    }
    
    public void displayFindDVDBanner() {
        io.print("=== Find a DVD in library ===");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public void displayUnknownDVD() {
        io.print("DVD not registered!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
	
}
