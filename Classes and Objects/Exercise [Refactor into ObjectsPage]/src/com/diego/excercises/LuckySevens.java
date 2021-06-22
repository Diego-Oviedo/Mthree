package com.diego.excercises;
import java.util.Random;
import java.util.Scanner;

public class LuckySevens {
	
	public void playLuckySevens() {
		int users_budget, max_amnt_held , dice01, dice02, rolls_count = 0, rolls_count_max_amnt = 0;
		
		System.out.println("************************\nLUCKY SEVENS\n************************\n");
		
		System.out.println("How much money would you like to bet?");
		
		users_budget = new Scanner(System.in).nextInt();//user's input
		
		max_amnt_held = users_budget;//at first what the user's bets would be the maximum earned
		
		dice01 = (new Random().nextInt(6)) + 1; // get a random number from 0 to 6 and then add 1 
		dice02 = (new Random().nextInt(6)) + 1; // get a random number from 0 to 6 and then add 1 
		
		
		while (users_budget > 0) {			
			dice01 = (new Random().nextInt(6)) + 1; // roll it again
			dice02 = (new Random().nextInt(6)) + 1; // roll it again
			
		if ((dice01 + dice02) == 7) {//If the sum of the two dice is equal to 7, the player wins $4
				
			users_budget = users_budget + 4;//users earns 4$
			
			if(users_budget > max_amnt_held) {// if the new user's budget is greater than the max amount held, then set users budget as value for max amount held
				
				max_amnt_held = users_budget;
				
				rolls_count_max_amnt ++;
				
				rolls_count ++;
				
			}else {
			
				rolls_count ++;
				
			}			
			
		}else if ((dice01 + dice02) != 7) {//otherwise, the player loses $1.
			
			users_budget = users_budget - 1;//users looses 1$
			
			rolls_count ++;
			
		}
		
		}
		
		if(users_budget < 0) {
			System.out.println("You didn't bet any money!!!!");
			
		}
		
		
		System.out.println("You are broke after "+rolls_count+" rolls.");
		
		System.out.println("You should have quit after "+rolls_count_max_amnt+" rolls when you had " + max_amnt_held + "$");
		
		
	}

}
