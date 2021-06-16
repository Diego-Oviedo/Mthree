package com.sg.foundations.flowcontrol.ifs;
import java.util.*;


public class GuessMe {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		int myNumber = 42, userGuess = 0;
		
		System.out.println("Hi There, let's play a game!\n" + "I have a number on mind, try to geuess the value and youll get a cookie...\n"
		+ "don't forget to hit enter to confirm your entry");
		
		
		
		try {
		userGuess = in.nextInt();
		
		if(userGuess > myNumber) {
			System.out.println("Too bad,"+userGuess+" went way too high. I chose " + myNumber + ".");
		}else if(userGuess == myNumber){
			System.out.println("Wow, nice guess!" +userGuess+ " That was it!");
		}else if(userGuess < myNumber) {
			System.out.println(userGuess + " ? Ha, nice try - too low! I chose " + myNumber + ".");
		}
		
		
		
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
		
		
		 }

		
		
		
		
		
	}
	
}
