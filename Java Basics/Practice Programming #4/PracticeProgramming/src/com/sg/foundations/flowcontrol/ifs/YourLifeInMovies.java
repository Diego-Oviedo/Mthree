package com.sg.foundations.flowcontrol.ifs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class YourLifeInMovies {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
			Scanner in = new Scanner(System.in);
			
			int userAge = 0;
			
			String userName;
			
			
			System.out.println("Hi There!\n" +  "let's play a game!\n" + "If you get me your name and year of born I can get you at least fun fac rourn the time you born\n"
			+ "don't forget to hit enter to confirm your entry");
			
			
			System.out.println("What's your name?");
			
			
			userName = in.next();
			
			
			System.out.println("Ok,"+userName+", when were you born?");
			
			
			try {
			userAge = in.nextInt();
			
			if(userAge < 2005 && userAge > 1995) { //year between 1995 and 2005
				
				System.out.println("Well "+userName+"...");
				System.out.println("Did you know...");
				System.out.println("Pixar's 'Up' came out over a decade ago.");
			
			}else if(userAge < 1995 && userAge > 1985){//year between 1985 and 1995
			
				System.out.println("Well "+userName+"...");
				System.out.println("Did you know...");
				System.out.println("Pixar's 'Up' came out over a decade ago.");
				System.out.println("Space Jam came out not last decade, but the one before THAT.");
			
			}else if(userAge < 1985 && userAge > 1975){//year between 1985 and 1995
			
				System.out.println("Well "+userName+"...");
				System.out.println("Did you know...");
				System.out.println("Pixar's 'Up' came out over a decade ago.");
				System.out.println("Space Jam came out not last decade, but the one before THAT.");
				System.out.println("the original Jurassic Park release is closer to the first lunar landing than it is to today.");
			
			}else if(userAge < 1975 && userAge > 1965){//year between 1985 and 1995
			
				System.out.println("Well "+userName+"...");
				System.out.println("Did you know...");
				System.out.println("Pixar's 'Up' came out over a decade ago.");
				System.out.println("Space Jam came out not last decade, but the one before THAT.");
				System.out.println("the original Jurassic Park release is closer to the first lunar landing than it is to today.");
				System.out.println("the MASH TV series has been around for almost half a century!");
			
			}
			
		
			}catch (InputMismatchException e) {
				
				System.out.println("Nice try "+userName+"! That wasn't a year...\n"+"Try it again");
			
			
			 }
		
		
	}
	
	

}
