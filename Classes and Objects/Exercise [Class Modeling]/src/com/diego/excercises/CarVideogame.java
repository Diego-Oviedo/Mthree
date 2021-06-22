package com.diego.excercises;

public class CarVideogame {

	final String fuel = "gas";//read-only
	String brand;//read/write
	String tramission;//read/write
	int year;//read/write
	int price_in_coins;//read/write
	
	//constructor for a videogame 
	public CarVideogame(String brand, String tramission, int year, int price_in_coins) {
		super();
		this.brand = brand;
		this.tramission = tramission;
		this.year = year;
		this.price_in_coins = price_in_coins;
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

	public int getPrice_in_coins() {
		return price_in_coins;
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
	public void setPrice_in_coins(int price_in_coins) {
		this.price_in_coins = price_in_coins;
	}

	public void getCarReport() {
		System.out.println("CarVideogame \nfuel: " + fuel + "\n brand: " + brand + "\n tramission: " + tramission + "\n year: " + year
				+ "\n price_in_coins: " + price_in_coins );
	}
	
	
	
	
}
