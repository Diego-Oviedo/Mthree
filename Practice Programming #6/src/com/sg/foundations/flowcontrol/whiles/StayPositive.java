package com.sg.foundations.flowcontrol.whiles;

public class StayPositive {

	public static void main(String[] args) {
		
		int counter = 10;
		
		System.out.println("Conting down...");
		
		while (counter > (-1) ) {
		
			System.out.println(counter);
			
			counter--;
		}
		
		System.out.println("Blast off!!");
		
		

	}

}
