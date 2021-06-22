package com.diego.excercises;
import java.time.LocalDate;

public class House3D {

	//fields for the 3-D design system
	double height;//read/write
	double depth;//read/write
	double width;//read/write
	final LocalDate creationDate = LocalDate.now();//read-only
	
	
	
	//constructor for the 3-D design system
	public House3D(double height, double depth, double width) {
		super();
		this.height = height;
		this.depth = depth;
		this.width = width;
	}

	
	//getters
	public double getHeight() {
		return height;
	}

	public double getDepth() {
		return depth;
	}

	public double getWidth() {
		return width;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	//setters
	public void setHeight(double height) {
		this.height = height;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	
	public void getHouseReport() {
		System.out.println("Date issued: " + creationDate);
		System.out.println("Your house will be mapped under the following measures: \nH: " +
		height+ "m" + "\nD: " +
		depth + "m" + "\nW: " +
		width + "m" );
		
	}
	
	
	
}
