package com.sg.foundations.flowcontrol.fors;

import java.util.Scanner;

	public class ForTimesFor {
	
	public static void main(String[] args) {
			
			System.out.println("Hey there!\nLet know what table would you like me to solve for you, I´ll do it up to the 15th time...");
			
			int tableOf = new Scanner(System.in).nextInt();
			
			int users_response, corrrect_answers = 0, result;
			
			int times_looped = (6+1);
			
			double percent50 = 0.50;
			
			double percent90 = 0.90;
			
			for(int i = 1 ; i < times_looped ; i++) {
				
				
				System.out.print(i + " * " + tableOf + " is ? ");
				
				
				result = (i * tableOf);
				
				users_response = new Scanner(System.in).nextInt();
				
				if (users_response == result ) {
					
					System.out.println("Correct!");
					
					corrrect_answers ++;
					
				}else if (users_response != result ){
					
					
					System.out.println("Sorry no, the answer is: " + result);
					
				}
					
				
			}
			
			if(corrrect_answers < (int) ((times_looped - 1) * percent50)) {
				
				
				System.out.println("You should study more :/ ");
				
			} else if(corrrect_answers >  (int)((times_looped - 1) * percent90)) {
				
				
				System.out.println("Great!! your archived more than the 90%");
			}
	
	
		}

}
