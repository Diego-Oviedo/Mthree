package com.diego.assessments;

public class SummativeSums {

	public static void main(String[] args) {
		
		System.out.println("************************\nSUMMATIVE SUMS\n************************\n");
		
		int [] array_1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
		
		int [] array_2 = { 999, -60, -77, 14, 160, 301 };
		
		int [] array_3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };
		
		System.out.println("#1 Array Sum: " + sumOfArray(array_1));
		
		System.out.println("#2 Array Sum: " + sumOfArray(array_2));
		
		System.out.println("#3 Array Sum: " + sumOfArray(array_3));
		

	}
	
	
	public static int sumOfArray(int [] array) {
		
		int result = 0 ;
		
		
		for(int n : array) {
			
			result = result + n;
		}
		
		return result;
	}
	

}
