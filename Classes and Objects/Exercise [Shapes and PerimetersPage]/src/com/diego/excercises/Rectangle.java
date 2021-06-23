package com.diego.excercises;

public class Rectangle extends Shape{

	String color;
	int area;
	int perimeter;
	int length;
	int width;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getArea() {
		length = 10;
		width = 15;
		
		area = (length * width);
		
		return area;
	}
	
	public int getPerimeter() {
		length = 15;
		width = 10;
		
		perimeter = 2 * (length + width);
		
		return perimeter;
	}
	
	
}
