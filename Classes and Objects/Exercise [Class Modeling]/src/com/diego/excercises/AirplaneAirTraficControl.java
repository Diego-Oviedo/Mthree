package com.diego.excercises;

import java.time.LocalDate;

public class AirplaneAirTraficControl {

	//fields for an air traffic control system
		String landingDestination;//read/write
		int radius;//read/write
		String airline;//read/write
		String flight;//read/write
		final LocalDate creationDate = LocalDate.now();//read-only
		
		public AirplaneAirTraficControl(String landingDestination, int radius, String airline, String flight) {
			super();
			this.landingDestination = landingDestination;
			this.radius = radius;
			this.airline = airline;
			this.flight = flight;
		}	
		
		//getters
		public String getLandingDestination() {
			return landingDestination;
		}


		public int getRadius() {
			return radius;
		}


		public String getAirline() {
			return airline;
		}


		public String getFlight() {
			return flight;
		}

	
		//setters
		public void setLandingDestination(String landingDestination) {
			this.landingDestination = landingDestination;
		}


		public void setRadius(int radius) {
			this.radius = radius;
		}


		public void setAirline(String airline) {
			this.airline = airline;
		}


		public void setFlight(String flight) {
			this.flight = flight;
		}
		
		public LocalDate getCreationDate() {
			return creationDate;
		}
		
		
		public void getAirplaneReport() {
			System.out.println("Date issued: " + creationDate);
			System.out.println("Landing destination: " + landingDestination);
			System.out.println("Radius: " + radius + "KM");
			System.out.println("Airlane: " + airline);
			System.out.println("Flight: " + flight);
			
			
		}

}
