package com.diego.excercises;
import java.util.*;

public class App {
	
	
	public static void main(String[] args) {
		
		calculator();
		
		
	}
	
	
	public static void calculator() {
		
		System.out.println("************************\nSIMPLE CALCULATOR\n************************\n");
		
		boolean ON = true;
		int user_nput = 0;
		String user_response;
		SimpleCalculator operation;
		int n1 = 0;
		int n2 = 0;
		int result = 0;
		
		do {
			
			System.out.println("Please choose one of the following operations:\n"
					+ "1) addition\n"
					+ "2) subtraction\n"
					+ "3) multiplication\n"
					+ "4) division\n");
			
			user_nput = new Scanner(System.in).nextInt();
			
			switch(user_nput) {
				case 1:
					System.out.println("Please provide the 1st number to " + "sum");
					n1 = new Scanner(System.in).nextInt();
					System.out.println("Please provide the 2nd number to " + "sum");
					n2 = new Scanner(System.in).nextInt();
					
					operation = new SimpleCalculator();
					result = operation.addition(n1, n2);
					System.out.println(n1 + " + " + n2 
											+ " = " + result);
				break;	
				
				case 2:
					System.out.println("Please provide the 1st number to " + "substract");
					n1 = new Scanner(System.in).nextInt();
					System.out.println("Please provide the 2nd number to " + "substract");
					n2 = new Scanner(System.in).nextInt();
					
					operation = new SimpleCalculator();
					result = operation.subtraction(n1, n2);
					System.out.println(n1 + " - " + n2 
										+ " = " + result);
				break;	
				
				case 3:
					System.out.println("Please provide the 1st number to " + "multiply");
					n1 = new Scanner(System.in).nextInt();
					System.out.println("Please provide the 2nd number to " + "multiply");
					n2 = new Scanner(System.in).nextInt();
					
					operation = new SimpleCalculator();
					result = operation.multiplication(n1, n2);
					System.out.println(n1 + " * " + n2 
										+ " = " + result);
				break;
				
				case 4:
					System.out.println("Please provide the 1st number to " + "divide");
					n1 = new Scanner(System.in).nextInt();
					System.out.println("Please provide the 2nd number to " + "divide");
					n2 = new Scanner(System.in).nextInt();
					
					operation = new SimpleCalculator();
					result = operation.division(n1, n2);
					System.out.println(n1 + " / " + n2 
										+ " = " + result);
				break;
			
			
			}
			
			System.out.println("\nWould you still need to perform another operation? \n1) Y\n2) N");
			
			user_response = new Scanner(System.in).next();
			
			if (user_response.equalsIgnoreCase("y")) {
				ON = true;
			}else if (user_response.equalsIgnoreCase("n") || !user_response.equalsIgnoreCase("y")){
				ON =false;
			}

		}while(ON);
		
		System.out.println("Thansk fo using the calculator!!! :D");
		System.exit(0);
	}
	
	

}
