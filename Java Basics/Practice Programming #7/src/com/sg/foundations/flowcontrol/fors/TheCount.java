package com.sg.foundations.flowcontrol.fors;
import java.util.*;

public class TheCount {

	public static void main(String[] args) {
		int startN = 20;//new Random().nextInt();
		int countByN;
		int stopAtN  = -20; //new Random().nextInt();
		int counter = 0;
		
		
		System.out.println("Start at: " + startN);
		System.out.println("Stop at: " + stopAtN);
		
		
		if (startN < stopAtN) {//best expected scenario 
			
			
			if (startN < 0) {//if starting value is negative 
				
				int aux = startN;//store the orginal value into an auxiliar var
				
				startN = Math.abs(startN);//convert the starting value into a positive to calculate the countByN 
				
				countByN = new Random().nextInt((stopAtN / startN));
				
				if(countByN == 0) {
					countByN = 1;
				}else {
					countByN = countByN;
				}
				
				startN = aux;// give back to startN its original value 
				
			}else {
				
				startN = startN;
				
				countByN = new Random().nextInt((stopAtN / startN));
				
				if(countByN == 0) {
					countByN = 1;
				}else {
					countByN = countByN;
				}
			}
			
			
			System.out.println("count by: " + countByN);
			
			for (int i = startN ; i <= stopAtN ; i = i+countByN) {
			
				if(counter < 3 ) {
					
					System.out.print( i + " ");
					
					counter++;
					
				}else if(counter >= 3 ) {
					
					System.out.println("- Ah ah ah!");
					counter = 0;
					i = (i-countByN); //if the count reaches 3 (end of the line) then decreases the value to a position before , this way next loop won´t loose the value on position 4th
				}
				
			}
			
		}else if (startN > stopAtN) {//if the stop point is lower than the starter point, reverse the count to go backwards 
			
			
			
			countByN = new Random().nextInt(Math.abs(stopAtN));// converting the last number of the series into a positive to get a random number between 0 and the last element 
			
			if(countByN == 0) {
				countByN = 1;
			}else {
				countByN = countByN;
			}
			
			countByN = countByN *= (-1);//converting the random value into negative 
			
			System.out.println("count by: " + countByN);
			
			for (int i = startN ; i >= stopAtN ; i = i+countByN) {//going backwards 
			
				if(counter < 3 ) {
					
					System.out.print( i + " ");
					
					counter++;
					
				}else if(counter >= 3  ) {
					
					System.out.println("- Ah ah ah!");
					counter = 0;
					i = (i-countByN); //if the count reaches 3 (end of the line) then increases the value to a position before , this way next loop won´t loose the value on position 4th
				}
				
			}
			
		}else if (startN == stopAtN) {//if the stop point is the same as the starter point, display one of them
			
			System.out.println("I can count that we only have a number: " + startN);
			
		}

	}

}
