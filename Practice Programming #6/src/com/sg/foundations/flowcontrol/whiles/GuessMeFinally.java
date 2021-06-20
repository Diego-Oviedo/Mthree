package com.sg.foundations.flowcontrol.whiles;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessMeFinally {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		int NumberToGuess = new Random().nextInt(101);
		boolean isNegative = new Random().nextBoolean();
		int counter = 0; //Declaring and initializing a counter to have record of the user's attempts 
		
		if(isNegative) {
			
			NumberToGuess = NumberToGuess *= (-1);
			
		}else {
			
			NumberToGuess = NumberToGuess;
			
		}
		
		int userGuess = 0;
		
		System.out.println("Hi There, let's play a game!\n" + "I have chosen a number between -100 and 100.\n Try to geuess the value and youll get a cookie...\n"
		+ "don't forget to hit enter to confirm your entry");
		
		
		//System.out.println("\n***************\n" + NumberToGuess + "\n***************\n" );
		
		
		while (userGuess != NumberToGuess) {//adding while to allow several attempts to guess the number
			
			
			if(userGuess > NumberToGuess && userGuess != 0) {//if number inputed is higher and different than zero (as I initialized the variable as zero)
				
				System.out.println("Too bad, way too high. Try again!\nYour guess: " + userGuess + ".");
			
			}else if(userGuess < NumberToGuess && userGuess != 0 ) {//if number inputed is lower and different than zero (as I initialized the variable as zero)
				
				System.out.println("Ha, nice try - too low! Try again!\nYour guess: " + userGuess + ".");
			
			}
			
			
			
			try {
				userGuess = in.nextInt(); //user's answer 
			
			}catch (InputMismatchException e) {
				
				System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
			
			
			 }
			
			counter ++; // adding an attempt 
		}
		
		

		
		if(userGuess == NumberToGuess && counter == 1 ){// if guessed at the first attempt 
		
			System.out.println("Wow, nice guess!" +userGuess+ " That was it!");
		
		}else if(userGuess == NumberToGuess && counter > 1 ){// if guessed after the first attempt 
		
			System.out.println("Finally! It's about time you got it!");
		
		} 
		
		
	

}

}
