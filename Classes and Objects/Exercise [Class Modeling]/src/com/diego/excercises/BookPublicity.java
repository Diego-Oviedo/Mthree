package com.diego.excercises;

import java.time.LocalDate;

public class BookPublicity {

	String title;//read/write
	String category;//read/write
	String body_text;//read/write
	int price;//read/write
	final LocalDate date_published = LocalDate.now();//read-only

	//constructor
	public BookPublicity(String title, String category, String body_text, int price) {
		super();
		this.title = title;
		this.category = category;
		this.body_text = body_text;
		this.price = price;
	}

	//getters
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getBody_text() {
		return body_text;
	}

	public int getPrice() {
		return price;
	}

	public LocalDate getDate_published() {
		return date_published;
	}

	//setters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setBody_text(String body_text) {
		this.body_text = body_text;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void getBookReport() {
		System.out.println("BookPublicity \ntitle: " + title + "\n category: " + category + "\n body_text: " + body_text + "\n price: "
				+ price + "\n date_published: " + date_published );
	} 
	
	
	
	
}
