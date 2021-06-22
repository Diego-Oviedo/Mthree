package com.diego.exercises;
import java.util.*;

public class InterestCalculator {

	public static void main(String[] args) {
		
		
		System.out.println("Hi John! \nSo you heared the news from Sue?  ,We do have a fund plan tha will pay you an annual percentage of your invesment."
				+ "\nWe'll be paying this in 4 instalments every 3 months...."
				+ "\n\n For instances:"
				+ "If you invest $500  for a year"
				+ "We'll pay you the 10% per year, in 4 instalments"
				+ "Every 3 months we will pay you 2.5% of your current balance"
				+ "By the end of the year you will have 551.90$");
		
		double annual_rate = 0;
		double amount_invested = 0 ;
		int installment_counter = 1; 
		double interest_per_term = 0;
		int year_term = 0;
		double inerest_earned= 0;
		double interest_earned_per_term = 0; 

		try {
		System.out.print("\nHow much do you want to invest?");
		amount_invested = (double) new Scanner(System.in).nextInt();
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
		}try {
		System.out.print("\nHow many years are investing?");
		year_term = new Scanner(System.in).nextInt();
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
		}try {
		System.out.print("\nWhat is the annual interest rate % growth?");
		annual_rate  = (double) new Scanner(System.in).nextInt();
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
		}
		
		
		interest_per_term = (annual_rate/4);
		
		interest_per_term = (interest_per_term * 0.010);
		
		
		System.out.println("\nCalculating...");
		
		
		for (int i=1 ; i<= year_term ; i++) {
			
			System.out.println("\nYear: " + i);
			
			System.out.println("Began with: " + amount_invested);
			
			
			while(installment_counter <= 4) {
				

				interest_earned_per_term = (amount_invested * interest_per_term);
				
				inerest_earned = inerest_earned + interest_earned_per_term;
				
				amount_invested = amount_invested + interest_earned_per_term;

				installment_counter ++;
			}
			
			System.out.println("Earned $" + inerest_earned);
			
			
			System.out.println("Ended with $" + amount_invested + "\n");
			
			installment_counter = 1;
	 
		}
		

	}

}
