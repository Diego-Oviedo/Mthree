package com.sg.foundations.flowcontrol.fors;
import java.util.*;

public class TraditionalFizzBuzz {

	public static void main(String[] args) {
		
		System.out.println("How many units of fizzing and buzzing do you need in your life?");
		
		int units = new Scanner(System.in).nextInt();
		
		int counter = 0;
		
		int fizz_buzz_counter = 0;
		
		int fizz_counter = 0;
		
		int buzz_counter =0;
		
		
		for (int i = 0; i <= units ; i ++ ) {
			
			if ( i != 0 && (i%3) == 0 && (i%5) == 0 ) {
				System.out.println("fizz buzz");
				
				fizz_buzz_counter ++;
			}else if ( i != 0 &&  (i%3) == 0) {
				System.out.println("fizz");
				
				fizz_counter ++;
			}else if ( i != 0 && (i%5) == 0 ) {
				System.out.println("buzz");
				
				buzz_counter++;
			}else {
				
				System.out.println(i);
			}
			
		}
		
		System.out.println("\nTRADITION!!!!!\n");
		
		System.out.println("Total fizz buzz: " + fizz_buzz_counter + "\n");
		
		System.out.println("Total fizz: " + fizz_counter + "\n");
		
		System.out.println("Total buzz: " + buzz_counter + "\n");
		

	}

}
