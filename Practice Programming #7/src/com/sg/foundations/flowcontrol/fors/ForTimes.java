package com.sg.foundations.flowcontrol.fors;
import java.util.*;

public class ForTimes {

	public static void main(String[] args) {
		
		System.out.println("Hey there!\nLet know what table would you like me to solve for you, I´ll do it up to the 15th time...");
		
		int tableOf = new Scanner(System.in).nextInt();
		
		
		
		for(int i = 1 ; i < (15+1) ; i++) {
			
			
			System.out.println(i + " * " + tableOf + " = " + (i * tableOf));
		}
		

	}

}
