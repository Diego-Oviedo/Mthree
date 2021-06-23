package com.diego.excercises;

public class Circle extends Shape{

	String color;
	double area;
	double perimeter;
	int radius;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getArea() {
		
		radius = 10;
		
		area = (Math.PI * Math.pow(radius, 2));
		
		return (int)Math.round(area);
	}
	
	public int getPerimeter() {
		
		radius = 10;
		
		perimeter = ( 2 * Math.PI * radius );
		
		return (int)Math.round(perimeter);
	}
	
	
}
