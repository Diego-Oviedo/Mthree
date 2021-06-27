package com.diego.addressbook.view.ui;
import java.util.Scanner;


public class UserIOImpl implements UserIO{

	@Override
	public void print(String message) {
		System.out.println(message);
		
	}

	@Override
	public double readDouble(String prompt) {
		System.out.println(prompt);
		double N =  new Scanner(System.in).nextDouble();
		
		return N;
	}

	@Override
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

	@Override
	public float readFloat(String prompt) {
		System.out.println(prompt);
		float N =  new Scanner(System.in).nextFloat();
		
		return N;
	}

	@Override
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

	@Override
	public int readInt(String prompt) {
		
		System.out.println(prompt);
		int N =  new Scanner(System.in).nextInt();
		return N;
	}

	@Override
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

	@Override
	public long readLong(String prompt) {
		System.out.println(prompt);
		long N =  new Scanner(System.in).nextLong();
		
		return N;
	}

	@Override
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

	@Override
	public String readString(String prompt) {
		System.out.println(prompt);
		String text = new Scanner(System.in).next();
		return text;
	}
	
	
}
