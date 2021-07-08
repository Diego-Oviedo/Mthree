package com.diego.vendingmachine.view.implementation;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.diego.vendingmachine.view.UserIO;

@Component("io")
public class UserIOImpl implements UserIO {

	
	public void print(String message) {
		System.out.println(message);
		
	}

	
	public double readDouble(String prompt) {
		System.out.println(prompt);
		double N =  new Scanner(System.in).nextDouble();
		
		return N;
	}
	
	public BigDecimal readBigDecimal(String amount) {
		System.out.println(amount);
		String entry = new Scanner(System.in).next();
		BigDecimal N = new BigDecimal(entry);
		
		return N;
	}
 
	
	public double readDouble(String prompt, double min, double max) {
		System.out.println(prompt);
		
		double N = new Scanner(System.in).nextDouble();;
		
			while(N < min || N > max) {
				System.out.println("The number is not between the range of min ("+min+") and max("+max+") numbers you've indicated.\n Please try it again\n");
				System.out.print("Number: ");
				N= new Scanner(System.in).nextDouble();

			}
			
	
		return N;
	}

	
	public float readFloat(String prompt) {
		System.out.println(prompt);
		float N =  new Scanner(System.in).nextFloat();
		
		return N;
	}

	
	public float readFloat(String prompt, float min, float max) {
		System.out.println(prompt);
		
		float N = new Scanner(System.in).nextFloat();;
		
			while(N < min || N > max) {
				System.out.println("The number is not between the range of min ("+min+") and max("+max+") numbers you've indicated.\n Please try it again\n");
				System.out.print("Number: ");
				N= new Scanner(System.in).nextFloat();

			}
			
	
		return N;
	}

	
	public int readInt(String prompt) {
		
		System.out.println(prompt);
		int N =  new Scanner(System.in).nextInt();
		return N;
	}

	
	public int readInt(String prompt, int min, int max) {
		System.out.println(prompt);
		
		int N = new Scanner(System.in).nextInt();;
		
			while(N < min || N > max) {
				System.out.println("The number is not between the range of min ("+min+") and max("+max+") numbers you've indicated.\n Please try it again\n");
				System.out.print("Number: ");
				N= new Scanner(System.in).nextInt();
						
			}
			
	
		return N;
	}

	
	public long readLong(String prompt) {
		System.out.println(prompt);
		long N =  new Scanner(System.in).nextLong();
		
		return N;
	}

	
	public long readLong(String prompt, long min, long max) {
		System.out.println(prompt);
		
		long N = new Scanner(System.in).nextLong();;
		
			while(N < min || N > max) {
				System.out.println("The number is not between the range of min ("+min+") and max("+max+") numbers you've indicated.\n Please try it again\n");
				System.out.print("Number: ");
				N= new Scanner(System.in).nextLong();

			}
			
	
		return N;
	}

	
	public String readString(String prompt) {
		System.out.println(prompt);
		String text = new Scanner(System.in).nextLine();
		return text;
	}
	
	
}
