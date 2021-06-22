package com.diego.assessments;
import java.util.*;

public class HealthyHearts {

	public static void main(String[] args) {
		
		
		System.out.println("************************\nHEALTHY HARTS\n************************\n");
		
		System.out.print("What is your age? ");
		
		
		int user_age = new Scanner(System.in).nextInt();
		
		int max_heart_rate = getMaximumHeartRate(user_age);
		
		int min_THRZone = getTargetHRZone(max_heart_rate) [0];
		
		int max_THRZone = getTargetHRZone(max_heart_rate) [1];
		
		System.out.println("\nYour maximum heart rate should be "+max_heart_rate+" beats per minute");
		System.out.println("Your target HR Zone is "+min_THRZone+" - "+max_THRZone+" beats per minute");
		
	}
	
	
	public static int getMaximumHeartRate(int age) {
		
	int result = 220 - age;
		
		return result;
	}
	
	public static int[] getTargetHRZone(int maxHeartRate) {
		
		int min = (int) (maxHeartRate * 0.50);
		
		int max = (int) Math.round((maxHeartRate * 0.85));
		
		
		int [] results = {min,max};
			
			return results;
		}


}
