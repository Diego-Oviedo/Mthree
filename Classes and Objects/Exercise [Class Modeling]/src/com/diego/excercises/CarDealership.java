package com.diego.excercises;

public class CarDealership {

	final String fuel = "gas";//read-only
	String brand;//read/write
	String tramission;//read/write
	int year;//read/write
	String serial_number;//read/write
	
	//constructor for car dealership inventory system
	public CarDealership(String brand, String tramission, int year, String serial_number) {
		super();
		this.brand = brand;
		this.tramission = tramission;
		this.year = year;
		this.serial_number = serial_number;
	}
	
	//getters

	public String getFuel() {
		return fuel;
	}

	public String getBrand() {
		return brand;
	}

	public String getTramission() {
		return tramission;
	}

	public int getYear() {
		return year;
	}

	public String getSerial_number() {
		return serial_number;
	}

	
	//setters

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setTramission(String tramission) {
		this.tramission = tramission;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public void getCarReport() {
		System.out.println("CarDealership \nfuel=" + fuel + "\n brand: " + brand + "\n tramission: " + tramission + "\n year: " + year
				+ "\n serial_number: " + serial_number);
	}
	
	

	
}
