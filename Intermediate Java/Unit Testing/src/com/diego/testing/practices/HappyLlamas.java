package com.diego.testing.practices;

public class HappyLlamas {

	public static void main(String[] args) {
		

	}
	
	
	public static boolean areTheLlamasHappy(boolean ultraBouncy, int trampolines) {
		boolean happy;
		
		if (ultraBouncy == true && trampolines >=24) {
			happy = true;
		}else if(ultraBouncy == false && trampolines >= 24 && trampolines <=42) {
			
			happy = true;
		}else {
			happy = false; 
		}
		
		
		return happy; 
	}

}
