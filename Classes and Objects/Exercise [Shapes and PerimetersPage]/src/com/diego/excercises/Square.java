package com.diego.excercises;

public class Square extends Shape{

	String color;
	int area;
	int perimeter;
	int side;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getArea() {
		
		side = 10;
		
		area = (int) Math.pow(side,2);
		
		return area;
	}
	
	public int getPerimeter() {
		
		side = 10;
		
		perimeter = (side * 4);
		
		return perimeter;
	}
	
}
