package com.sg.foundations.flowcontrol.whiles;
import java.util.*;

public class StayPositive {

	public static void main(String[] args) {
		
		System.out.println("Hello there!\n Give me a number an I'll give you th");
		
		int startPoint = new Scanner(System.in).nextInt();//Adding user´s input 
		
		int counter = 0 ;
		
		System.out.println("Conting down...");
		
		
		
		while (startPoint > (-1) && counter < 10) {
		
			System.out.print(startPoint + " ");
			
			startPoint--;
			
			counter ++;
			
			
			if(startPoint > (-1) && counter == 10) { //if there still something to print and there is already 10 numbers in line, then break line
				
				System.out.print("\n");
				
				counter = 0;
			}
		}
		
		
		System.out.println("Blast off!!");
		
		

	}

}
