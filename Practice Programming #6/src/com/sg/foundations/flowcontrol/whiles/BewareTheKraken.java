package com.sg.foundations.flowcontrol.whiles;

import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
	    public static void main(String[] args) {

	        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
	        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

	        int depthDivedInFt = 0;
	        

	        // Turns out the ocean is only so deep, 36200 at the deepest survey,
	        // so if we reach the bottom ... we should probably stop.
	        while(depthDivedInFt < 36200){ // if we change the condition to true, in this specific case, the program will still works as expected, 
	        							  // as we have the brake statements, without them the loop will be infinity as it will be always true and there is no other code that will change the state of it 
	            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
	            
	            int fishType = new Random().nextInt(10+1);
	            
	            switch(fishType) {
	            case 1:
	            	System.out.println("Oh! I see a " + "Billfish");
	            	break;
	            case 2:
	            	System.out.println("Oh! I see a " + "Goldfish");
	            	break;
	            case 3:
	            	System.out.println("Oh! I see a " + "Guppy");
	            	break;
	            case 4:
	            	System.out.println("Oh! I see a " + "Dorado");
	            	break;
	            case 5:
	            	System.out.println("Oh! I see an " + "Electric ray");
	            	break;
	            case 6:
	            	System.out.println("Oh! I see a " + "Flagfish");
	            	break;	
	            case 7:
	            	System.out.println("Oh! I see a " + "John Dory");
	            	break;
	            case 8:
	            	System.out.println("Oh! I see a " + "Hammerhead shark");
	            	break;
	            case 9:
	            	System.out.println("Oh! I see a " + "Sturgeon");
	            	break;	
	            case 10:
	            	System.out.println("Oh! I see an " + "Anglerfish");
	            	break;	
	            
	            }
	            
	            System.out.println("Do you want to stop?");
	            
	            if(new Scanner(System.in).next().equalsIgnoreCase("y")){
	                System.out.println("Okay, let's get back!");
	                break;
	            }

	            if(depthDivedInFt >= 20000){
	                System.out.println("Uhhh, I think I see a Kraken, guys ....");
	                System.out.println("TIME TO GO!");
	                break;
	            }

	            // I can swim, really fast! 500ft at a time!
	            depthDivedInFt += 1000;
	        }
	        System.out.println("");
	        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
	        System.out.println("I bet we can do better next time!");
	    }
	}
