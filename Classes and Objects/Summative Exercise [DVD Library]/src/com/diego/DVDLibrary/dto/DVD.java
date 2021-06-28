package com.diego.DVDLibrary.dto;

public class DVD {
	
	private String SKU;
	private String title;
	private String release_date;
	private double MPAA_rating;
	private String author;
	private String studio;
	private String user_note;
	
	public DVD(String sKU) {
		super();
		SKU = sKU;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public double getMPAA_rating() {
		return MPAA_rating;
	}

	public void setMPAA_rating(double mPAA_rating) {
		MPAA_rating = mPAA_rating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUser_note() {
		return user_note;
	}

	public void setUser_note(String user_note) {
		this.user_note = user_note;
	}
	
	
}
