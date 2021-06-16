package com.sg.foundations.flowcontrol.ifs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriviaNight {

	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		int correctAcounter = 0, userInput =0;
		
		System.out.println("It's TRIVIA NIGHT! Are you ready?!\n" + "I'll trhow few questions with multiple options, to answer, input the number that corresponds to the selected answer\n"
		+ "don't forget to hit enter to confirm your entry");
		
		
		
		try {
			
			System.out.println("FIRST QUESTION!");
			
			System.out.println("What is the Lowest Level Programming Language?");
			
			System.out.println("1) Source Code\n"
							 + "2) Assembly Language\n"
							 + "3) C#\n"
							 + "4) Machine Code\n");
			
		userInput = in.nextInt();
		
		if(userInput <= 0 || userInput > 4) {
			System.out.println("That's not a choice, please enter a value between 1 and 4 ");
		}else if(userInput == 1){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: " + "1) Source Code\n");
		}else if(userInput == 2){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: "+ "2) Assembly Language\n");
		}else if(userInput == 3){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: "+ "3) C#\n");
		}else if(userInput == 4){
			System.out.println("Correct anwer!");
			System.out.println("YOUR ANSWER: " + "4) Machine Code\n");
			correctAcounter ++;
		}
		
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
	
		 }
		
		try {
			
			System.out.println("SECOND QUESTION!");
			
			System.out.println("Website Security CAPTCHA Forms Are Descended From the Work of?");
			
			System.out.println("1) Grace Hopper\n"
							 + "2) Alan Turing\n"
							 + "3) Charles Babbage\n"
							 + "4) Larry Page\n");
			
		userInput = in.nextInt();
		
		if(userInput <= 0 || userInput > 4) {
			System.out.println("That's not a choice, please enter a value between 1 and 4 ");
		}else if(userInput == 1){
			System.out.println("Correct anwer!");
			System.out.println("YOUR ANSWER: " + "1) Grace Hopper\n");
			correctAcounter ++;
		}else if(userInput == 2){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: "+ "2) Alan Turing\n");
		}else if(userInput == 3){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: "+ "3) Charles Babbage\n");
		}else if(userInput == 4){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: " + "4) Larry Page\n");
		}
		
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
	
		 }
		
		
		try {
			
			System.out.println("LAST QUESTION!");
			
			System.out.println("Which of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?");
			
			System.out.println("1) Serenity\n"
							 + "2) The Battlestar Galactica\n"
							 + "3) The USS Enterprise\n"
							 + "4) The Millennium Falcon\n");
			
		userInput = in.nextInt();
		
		if(userInput <= 0 || userInput > 4) {
			System.out.println("That's not a choice, please enter a value between 1 and 4 ");
		}else if(userInput == 1){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: " + "1) Serenity\n");
		}else if(userInput == 2){
			System.out.println("Correct anwer!");
			System.out.println("YOUR ANSWER: "+ "2) The Battlestar Galactica\n");
			correctAcounter ++;
		}else if(userInput == 3){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: "+ "3) The USS Enterprise\n");
		}else if(userInput == 4){
			System.out.println("Wrong anwer!");
			System.out.println("YOUR ANSWER: " + "4) The Millennium Falcon\n");
		}
		
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
	
		 }
		
		
		
		if (correctAcounter == 0) {
			
			System.out.println("You failed! :( with" +correctAcounter+ " correct answers");
		}else if (correctAcounter > 0 || correctAcounter >= 4) {
			
			System.out.println("Nice job - you got "+correctAcounter+" correct!");
		}
		
		
	
	}
}
