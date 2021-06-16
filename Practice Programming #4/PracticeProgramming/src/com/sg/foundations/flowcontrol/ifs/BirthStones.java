package com.sg.foundations.flowcontrol.ifs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BirthStones {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		
		int jan = 1, feb = 2, mar = 3, apr = 4, may = 5, jun = 6, jul = 7, aug = 8, sep = 9, oct =10, nov = 11, dec = 12, userInput =0;
		
		System.out.println("Hi There, let's play a game!\n" + "Shoot me your month of birth month number,and I'll give your birthstone...\n"
		+ "don't forget to hit enter to confirm your entry");
		
		
		
		try {
		userInput = in.nextInt();
		
		if(userInput <= 0 || userInput > 12) {
			System.out.println("That's not a month number, please enter a value between 1(Jan.) and 12(Dec.) ");
		}else if(userInput == 1){
			System.out.println("The birth Stone for "+ "January" +" is "+ "Garnet");
		}else if(userInput == 2){
			System.out.println("The birth Stone for "+ "February" +" is "+ "Amethyst");
		}else if(userInput == 3){
			System.out.println("The birth Stone for "+ "March" +" is "+ "Aquamarine");
		}else if(userInput == 4){
			System.out.println("The birth Stone for "+ "April" +" is "+ "Diamond");
		}else if(userInput == 5){
			System.out.println("The birth Stone for "+ "May" +" is "+ "Emerald");
		}else if(userInput == 6){
			System.out.println("The birth Stone for "+ "June" +" is "+ "Pearl");
		}else if(userInput == 7){
			System.out.println("The birth Stone for "+ "July" +" is "+ "Ruby");
		}else if(userInput == 8){
			System.out.println("The birth Stone for "+ "August" +" is "+ "Peridot");
		}else if(userInput == 9){
			System.out.println("The birth Stone for "+ "September (month of champions)" +" is "+ "Sapphire");
		}else if(userInput == 10){
			System.out.println("The birth Stone for "+ "October" +" is "+ "Opal");
		}else if(userInput == 11){
			System.out.println("The birth Stone for "+ "November" +" is "+ "Topaz");
		}else if(userInput == 12){
			System.out.println("The birth Stone for "+ "December" +" is "+ "Turquoise");
		}
		
		
		
		}catch (InputMismatchException e) {
			
			System.out.println("Nice try! That wasn't a number...\n"+"Try it again");
		
		
		 }

		
		
		
		
		
	}
	
	
}
