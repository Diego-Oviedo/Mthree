package com.diego.excercises;

import java.time.LocalDate;

public class AirplaneFlightSimulator {

	
	//fields for a flight simulator system
	int airSpeed;//read/write
	int verticalSpeed;//read/write
	int tachometer;//read/write
	final LocalDate creationDate = LocalDate.now();//read-only
	


	//constructor for the flight simulator system
	public AirplaneFlightSimulator(int airSpeed, int verticalSpeed, int tachometer) {
		super();
		this.airSpeed = airSpeed;
		this.verticalSpeed = verticalSpeed;
		this.tachometer = tachometer;
	}

	//getters
	public int getAirSpeed() {
		return airSpeed;
	}


	public int getVerticalSpeed() {
		return verticalSpeed;
	}


	public int getTachometer() {
		return tachometer;
	}

	//setters
	public void setAirSpeed(int airSpeed) {
		this.airSpeed = airSpeed;
	}


	public void setVerticalSpeed(int verticalSpeed) {
		this.verticalSpeed = verticalSpeed;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	
	public void getAirplaneReport() {
		System.out.println("Date issued: " + creationDate);
		System.out.println("Air peed: " + airSpeed + "KMH");
		System.out.println("Vertical speed" + verticalSpeed + "MPH");
		System.out.println("Tachometer: " + tachometer + "RPM");
	}
	
	
}
