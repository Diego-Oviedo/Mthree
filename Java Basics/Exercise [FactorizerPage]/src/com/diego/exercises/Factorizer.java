package com.diego.exercises;
import java.util.*;

public class Factorizer {

	public void startFactorizer() {
	
		int number, sum = 0, factors_count = 0;
		
		boolean isPrime = true;

		
		System.out.println(
				"**********************************************************************************"
				+ "\nA perfect number is a number where all the factors of the number, excluding the number itself, add up to that number. \nFor example, the first perfect number is 6 because its factors 1, 2, and 3 add up to 6.\n"
				+ "\n"
				+ "A prime number is defined as a number greater than 1 that has only itself and 1 as factors. \nFor example, 3 is a prime number, but 4 is not.\n"
				+ "**********************************************************************************\n"
				+"\nHello There!\nPlease introduce a number and I'll let you know if the number is perfect or not, as its factors\n");
		
		
		number = new Scanner(System.in).nextInt();
		
		
		System.out.println("The factors of "+number+" are:");
		
		for(int i = 1 ; i <= number ; i++) {
			
			if( (number%i) == 0) {
				
				factors_count = factors_count + i;
				
				sum ++;
				
				System.out.print(i + " ");
				
				isPrime = false ;
			}
			
		}
		
		
		System.out.println("\n" + number + " has " + sum + " factors");
		
		if((factors_count - number )==number) {
			
			System.out.println( number + " is a prefect number");
			
		}else {			
			System.out.println( number + " is NOT a prefect number");
		}
		
		
		if(!isPrime) {
			
			System.out.println( number + " is NOT a prime number");
			
		}else {
			
			System.out.println( number + " is a prime number");
		}
		
	}
}
