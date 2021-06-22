package com.diego.excercises;

public class PenAndPaper_pracitce {

	public static void main(String[] args) {
		
		areEvenlySpcd(21,28,14);

	}
	
	
	public static void areEvenlySpcd(int first, int second, int third) {
		
		int spc_btw_SM = 0;
		int spc_btw_ML = 0;
		
		
		//I missed to sort the numbers first from the small to the large 
		
		if (first < second) {
			spc_btw_SM = (second - first);
		}else if (first > second) {
			spc_btw_SM = (first - second);
		}else if(first == second) {
			spc_btw_SM = 0;
		}
		
		if(second < third) {
			spc_btw_ML = (third - second);
		}else if (second > third) {
			spc_btw_ML = (second - third);
		}else if(second == third) {
			spc_btw_ML = 0;
		}
		
		
		if (spc_btw_SM == spc_btw_ML) {
			System.out.println("The numbers: \n");
			System.out.println(first+","+second+","+third);
			System.out.println("Are evenly spaced");
		}else {
			System.out.println(first+","+second+","+third);
			System.out.println("Are NOT evenly spaced");
		}
		
		
	}

}
