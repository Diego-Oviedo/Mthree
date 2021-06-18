package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MiniZork {

    public static void main(String[] args) throws InterruptedException {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine().toLowerCase();// adding toLowerCase method, in order to avoid a capitalization mismatch

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine().toLowerCase();// adding toLowerCase method, in order to avoid a capitalization mismatch

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine().toLowerCase();// adding toLowerCase method, in order to avoid a capitalization mismatch

                if (action.equals("keep looking")) {
                	System.out.println("*******************************************************************\n");//adding format 
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                    System.exit(0);//adding end of the game 
                } else if (action.equals("run away")) {
                	System.out.println("*******************************************************************\n");//adding format 
                	System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive...");//scenario 3 added
                    TimeUnit.MINUTES.sleep(2); //adding a dramatic suspense moment....
                    System.out.println("you´ve seen a light not far from you");//scenario 3 added
                    System.out.println("It´s a red color payphone. You approche");//scenario 3 added
                    System.out.println("The phone rings!!!!!\n");//scenario 3 added
                    System.out.println("Answer the phone?");//option added to scenario 3
                    System.out.println("go back to the withe house?");//option added to scenario 3
                    action = userInput.nextLine().toLowerCase();//adding user's response
                }
            } else if (action.equals("answer the phone") || action.equals("answer the phone?")) { 
            	System.out.println("*******************************************************************\n");//adding format 
            	System.out.println("A terrorific voice says: ");//scenario 4 added
            	System.out.println("YOU FORGOT TO COMMIT YOUR PROJECT!!!!!!!!\n");//scenario 4 added
            	System.out.println("you woke up an realized everithing was a dream.");//scenario 4 added
            	System.exit(0);//adding end of the game 
            	
            }
        } else if (action.equals("go back to the withe house") || action.equals("go back to the withe house") || action.equals("go to the house" )) { 
        	System.out.println("*******************************************************************\n");//adding format 
        	System.out.println("you get inside and realized ther is something differen...");//scenario 5 added
        	System.out.println("everything is clean and sharp, almost steril");//scenario 5 added
        	System.out.println("you see a withe rose in the middle of a huge oak table");//scenario 5 added
        	System.out.println("someone pick your back with a knife");//scenario 3 added
        	System.out.println("you turn back?");//option added to scenario 5
        	System.out.println("you pounce against the table?");//option added to scenario 5
        	action = userInput.nextLine().toLowerCase();//adding user's response
        	
        }else if (action.equals("turn back?") || action.equals("turn back?")) { 
        	System.out.println("*******************************************************************\n");//adding format 
        	System.out.println("That was a knife to cut your birthday cake  ");//scenario 6 added
        	System.out.println("Happy birthday!!!!!!!!\n");//scenario 6 added
        	System.exit(0);//adding end of the game 
        	
        }else if (action.equals("you pounce against the table?") || action.equals("you pounce against the table")) { 
        	System.out.println("*******************************************************************\n");//adding format 
        	System.out.println("you get to sacape and run safe to your house");//scenario 7 added
        	System.out.println("Congrats!\n");//scenario 7 added
        	System.exit(0);//adding end of the game 
        	
        }
    }
}
