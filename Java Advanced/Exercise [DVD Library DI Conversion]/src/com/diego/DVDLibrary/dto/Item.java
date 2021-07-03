package com.diego.DVDLibrary.dto;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Item {
	
	private String SKU;
	private String title;
	private LocalDate release_date;
	private double MPAA_rating;
	private String author;
	private String studio;
	private String user_note;
	
	public Item(String sKU) {
		super();
		SKU = sKU;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
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

	public LocalDate getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDate release_date) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(MPAA_rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((SKU == null) ? 0 : SKU.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((studio == null) ? 0 : studio.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user_note == null) ? 0 : user_note.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Double.doubleToLongBits(MPAA_rating) != Double.doubleToLongBits(other.MPAA_rating))
			return false;
		if (SKU == null) {
			if (other.SKU != null)
				return false;
		} else if (!SKU.equals(other.SKU))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (studio == null) {
			if (other.studio != null)
				return false;
		} else if (!studio.equals(other.studio))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_note == null) {
			if (other.user_note != null)
				return false;
		} else if (!user_note.equals(other.user_note))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DVD [SKU=" + SKU + ", title=" + title + ", release_date=" + release_date + ", MPAA_rating="
				+ MPAA_rating + ", author=" + author + ", studio=" + studio + ", user_note=" + user_note + "]";
	}
	
	//UTILITY METHODS 
	
		public static LocalDate yearToDateFormatter(String year) {
			
			
			String date_to_format = "01/01/"+year+"";
			
		
			LocalDate date_formatted = LocalDate.parse(date_to_format, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
			
			return date_formatted;
		}
	
	
}
