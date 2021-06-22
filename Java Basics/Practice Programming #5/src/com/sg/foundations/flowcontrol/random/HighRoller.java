package com.sg.foundations.flowcontrol.random;
import java.util.*;

public class HighRoller {

    public static void main(String[] args) {

        Random diceRoller = new Random();
        
        int userInput = 0;//declaring and initializing the user's input as variable
        
        
        System.out.println("Hey there!\n let's play a game...\n Chose the number of sides a dice can have, then lest roll your fortune...");
        
        userInput =new Scanner(System.in).nextInt(); //storing user's entry
        

        int rollResult = diceRoller.nextInt(userInput) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch.");//changing result of condition
        }if (rollResult == userInput) {//adding condition
        	
        	System.out.println("You rolled a critical! Nice job!");//adding result of condition
        }
        
        
        
    }
}
