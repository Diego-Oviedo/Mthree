package com.sg.foundations.flowcontrol.random;
import java.util.*;

public class FortuneCookie {

	public static void main(String[] args) {
		
		Random random = new Random();
		
		int fortune = random.nextInt(11);
		
		//System.out.println(fortune);
		
		if (fortune == 1) {
		
			System.out.println("Your fortune is: " + "Those aren't the droids you're looking for.");
			
		}else if (fortune == 2) {
		
			System.out.println("Your fortune is: " + "Never go in against a Sicilian when death is on the line!");
			
		}else if (fortune == 3) {
		
			System.out.println("Your fortune is: " + "Goonies never say die.");
			
		}else if (fortune == 4) {
		
			System.out.println("Your fortune is: " + "With great power, there must also come — great responsibility.");
			
		}else if (fortune == 5) {
		
			System.out.println("Your fortune is: " + "Never argue with the data.");
			
		}else if (fortune == 6) {
		
			System.out.println("Your fortune is: " + "Try not. Do, or do not. There is no try.");
			
		}else if (fortune == 7) {
		
			System.out.println("Your fortune is: " + "You are a leaf on the wind, watch how you soar.");
			
		}else if (fortune == 8) {
		
			System.out.println("Your fortune is: " + "Do absolutely nothing, and it will be everything that you thought it could be.");
			
		}else if (fortune == 9) {
		
			System.out.println("Your fortune is: " + "Kneel before Zod.");
			
		}else if (fortune == 10) {
		
			System.out.println("Your fortune is: " + "Make it so.");
			
		}else {
			
			System.out.println("You create your own fortune");
			
		}

	}

}
