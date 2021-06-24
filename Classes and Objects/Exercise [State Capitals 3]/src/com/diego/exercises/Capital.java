package com.diego.exercises;

public class Capital {

	private String name; 
	private int population;
	private double square_mileage;
	
	
	
	public Capital() {
		super();
		
	}

	public Capital(String name, int population, double square_mileage) {
		super();
		this.name = name;
		this.population = population;
		this.square_mileage = square_mileage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getSquare_mileage() {
		return square_mileage;
	}

	public void setSquare_mileage(double square_mileage) {
		this.square_mileage = square_mileage;
	}
	
	
}
