package com.diego.excercises;

import java.time.LocalDate;

public class BookLibrary {

	String SKU;//read/write
	String title;//read/write
	int price;//read/write
	String category;//read/write
	final LocalDate date_added = LocalDate.now();//read-only
	
	//constructor
	public BookLibrary(String sKU, String title, int price, String category) {
		super();
		SKU = sKU;
		this.title = title;
		this.price = price;
		this.category = category;
	}

	//getters
	public String getSKU() {
		return SKU;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public LocalDate getDate_added() {
		return date_added;
	}

	//setters
	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void getBookReport() {
		System.out.println("BookLibrary \nSKU: " + SKU + "\n title: " + title + "\n price: " + price + "\n category: " + category
				+ "\n date_added: " + date_added );
	}
	
	
	
}
