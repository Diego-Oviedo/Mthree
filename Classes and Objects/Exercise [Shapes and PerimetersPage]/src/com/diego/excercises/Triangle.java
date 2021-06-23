package com.diego.excercises;

public class Triangle extends Shape{

	String color;
	int area;
	int perimeter;
	int side1;
	int side2;
	int height;
	int base;
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getArea() {
		
		base = 15;
		height = 7;
		
		area = (base *  height) / 2;
		
		return area;
	}
	
	public int getPerimeter() {
		
		side1 = 20;
		side2 = 30;
		base = 15;
				
		perimeter = (side1+base+side2);
		
		return perimeter;
	}
	
	
}
