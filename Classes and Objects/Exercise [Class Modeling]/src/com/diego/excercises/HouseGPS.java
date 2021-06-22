package com.diego.excercises;

import java.time.LocalDate;

public class HouseGPS {

	//fields for the GPS mapping system
		float latitude;//read/write
		float longitude;//read/write
		float altitude;//read/write
		String direction;//read/write
		final LocalDate creationDate = LocalDate.now();//read-only
	
	//constructor for the GPS mapping system
	public HouseGPS(float latitude, float longitude, float altitude,String direction) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.direction = direction;
	}	
	
	//getters
		public float getLatitude() {
			return latitude;
		}

		public float getLongitude() {
			return longitude;
		}

		public float getAltitude() {
			return altitude;
		}

		public String getDirection() {
			return direction;
		}
		
		public LocalDate getCreationDate() {
			return creationDate;
		}
		
		
		
	//setters
		public void setLatitude(float latitude) {
			this.latitude = latitude;
		}

		public void setLongitude(float longitude) {
			this.longitude = longitude;
		}

		public void setAltitude(float altitude) {
			this.altitude = altitude;
		}

		public void setDirection(String direction) {
			this.direction = direction;
		}	
	
	public void getGPSReport(HouseGPS home) {
		System.out.println("Date issued: " + home.getCreationDate());
		System.out.println("Your house will be located in: \n(" + home.getLongitude() + "' ," + home.getLatitude() + "'' ," + home.getAltitude() + "°)");
		System.out.println("Facing: " + home.getDirection());
	}
	
		
}
