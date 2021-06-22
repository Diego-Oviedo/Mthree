package com.sg.foundations.flowcontrol.arrays;

public class SimpleCombination {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 35, 45, 47, 49}; // 12 numbers
        int[] secondHalf = {51, 54, 68, 71, 75, 78, 82, 84, 85, 89, 91, 100}; // also 12!
        
        int[] wholeNumbers = new int[24];
        
        int aux;

        for (int i = 0 ; i <= 24 ; i++) {
		
        		if (i <= 11) {
        			
        			wholeNumbers [i] = firstHalf [i];
        		
        			
        		}else if (i > 11 && i < 24) {
        			
        			wholeNumbers [i] = secondHalf [i - 12];
        			
        		}
        		
        }

        for (int n : wholeNumbers) {
        	
        	System.out.print(n + " ");
        }

    }
}
