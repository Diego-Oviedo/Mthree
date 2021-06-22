package com.diego.assessments;
import java.io.RandomAccessFile;
import java.util.*;

public class RockPaperScissors {
	
	public static void playRockPaperScissors() {
		String play_again = "n";
		
		do {
			
			System.out.println("************************\nROCK PAPER SCISSORS\n************************\n");
			System.out.println("How many rounds would you like to play?");
			
			int user_games = 0;
			int computer_games = 0;
			int tie_games =0;
			int user_choice = 0;
			int computer_choice = 0;
			int round_counter = 1;
			int rounds_to_play = 0;

			
			try {
				rounds_to_play = new Scanner(System.in).nextInt();//validation added: a number must be provided
			
			}catch (InputMismatchException e) {
				System.out.println("Nice try! That wasn't a number...\nTry it again");
			}

			
			if(rounds_to_play < 1 || rounds_to_play >10) {//number of rounds must be between 1 and 10
				
				System.out.println("Error: the round is less than 1 or greater than 10");
				
				System.exit(0);
			}	
			
			
		while (round_counter <= rounds_to_play) {//while there is rounds to play 
			
			System.out.println("****************************\nROUND " + (round_counter) + "\n****************************\n");
		
			System.out.println("Please write the number corresponding to your choice and hit enter...");
			
			System.out.println("\n1) Rock\n"
							 + "2) Paper\n"
							 + "3) Scissors\n");
			
			user_choice = new Scanner(System.in).nextInt();
			
			if(user_choice < 1 || user_choice > 3) {//validation added: choose a valid option 
				
				System.out.println("\nChoose a number between 1 and 3!!!\n");
				user_choice = new Scanner(System.in).nextInt();
			}//end of IF
			
			switch(user_choice) {
			case 1:
				user_choice = 1;
				break;
			case 2: 
				user_choice = 2;
				break;
			case 3: 
				user_choice = 3;
				break;				
			}//end of switch loop
			
			computer_choice = (new Random().nextInt(2)) + 1 ; //generating computers choice 
			
		
		if(user_choice == computer_choice) {//IF user and computer has the same results 
			System.out.println("\n     TIE!!!!!");
			
			tie_games++;
			round_counter++;
			
		}else if(user_choice == 2 && computer_choice == 1){// if user choose paper and computer rock
			
			System.out.println("\n     You win!!!!!");
			
			user_games++;
			round_counter++;
			
		}else if(user_choice == 2 && computer_choice != 1){// if user choose paper and computer scissors
			
			System.out.println("\n     Computer wins!!!!!");
			
			computer_games++;
			round_counter++;
			
		}else if(user_choice == 3 && computer_choice == 2){// if user choose scissors and computer paper
			
			System.out.println("\n     	You win!!!!!");
			
			user_games++;
			round_counter++;
			
		}else if(user_choice == 3 && computer_choice != 2){// if user choose scissors and computer rock
			
			System.out.println("\n     Computer wins!!!!!");
			
			computer_games++;
			round_counter++;
			
		}else if(user_choice == 1 && computer_choice == 3){// if user choose rock and computer scissors
			
			System.out.println("\n     	You win!!!!!");
			
			user_games++;
			round_counter++;
			
		}else if(user_choice == 1 && computer_choice != 3){// if user choose rock and computer paper
			
			System.out.println("\n     Computer wins!!!!!");
			
			computer_games++;
			round_counter++;
			
		}
			
			
		}//end of while for rounds to play
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++\nTimes played " + (round_counter-1) + "\n");
		
		System.out.println("Ties: " +tie_games);
		System.out.println("Your games won: " +user_games);
		System.out.println("Computer games won: " + computer_games + "\n+++++++++++++++++++++++++++++++++++++++++\n");
		
		if(user_games > computer_games) {
		System.out.println("Winner: YOU with: " + user_games + " games won");
		
		}else if(user_games < computer_games) {
		System.out.println("Winner: computer with: " + computer_games + " games won");
		}
		
		System.out.print("\nDo you still want to play? (Y/N) ");//Ask if the user wants to still playing 
		
		play_again = new Scanner(System.in).next();
		
		}while (play_again.equalsIgnoreCase("y"));//while the user's want's to play 

		
		System.out.println("Thanks for playing!");
		System.exit(0);
	}
}
