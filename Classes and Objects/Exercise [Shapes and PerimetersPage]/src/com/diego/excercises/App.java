package com.diego.excercises;

public class App {

	public static void main(String[] args) {
		
		Triangle shape = new Triangle();
		
		shape.setColor("Blue");
		
		System.out.println(shape.getColor());
		System.out.println(shape.getPerimeter());
		System.out.println(shape.getArea());
	}

}
