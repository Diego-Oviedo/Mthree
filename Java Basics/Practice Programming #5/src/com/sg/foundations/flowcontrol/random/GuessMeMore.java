package com.sg.foundations.flowcontrol.random;
import java.util.*;

public class GuessMeMore {
		
		@SuppressWarnings("unlikely-arg-type")
		public static void main(String[] args) {
			
			
			Scanner in = new Scanner(System.in);
			
			int NumberToGuess = new Random().nextInt(101);//adding a random generator for a positive number
			boolean isNegative = new Random().nextBoolean();//adding a random generator to choose if negative or positive
			
			if(isNegative) {//adding condition to convert or not the number into a negative 
				
				NumberToGuess = NumberToGuess *= (-1);
			}else {
				
				NumberToGuess = NumberToGuess;
				
			}
			
			int userGuess = 0;
			
			System.out.println("Hi There, let's play a game!\n" + "I have chosen a number between -100 and 100.\n Try to geuess the value and youll get a cookie...\n"
			+ "don't forget to hit enter to confirm your entry");
			
			
			
			try {
			userGuess = in.nextInt();
			
			if(userGuess > NumberToGuess) {
				System.out.println("Too bad,"+userGuess+" went way too high. I chose " + NumberToGuess + ".");
			}else if(userGuess == NumberToGuess){
				System.out.println("Wow, nice guess!" +userGuess+ " That was it!");
			}else if(userGuess < NumberToGuess) {
				System.out.println(userGuess + " ? Ha, nice try - too low! I chose " + NumberToGuess + ".");
			}
			
			
			
			}catch (InputMismatchException e) {
				
				System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
			
			
			 }

		

	}
}
