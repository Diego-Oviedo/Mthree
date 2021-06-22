package com.sg.foundations.flowcontrol.whiles;
import java.util.*;

public class DoOrDoNot {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;
       
        if (input.next().equals("y")) {
            doIt = true; // DO IT!
            
        } else {
            doIt = false; // DONT YOU DARE!
            
        }

        boolean iDidIt = false;
//
//        do { // The variable iDidIt performed and action (change the value to true) and then check the condition
//        	// as the Do while loop declarers the statement first and then checks the condition
//        	//also Java reads from the top to the bottom 
//            iDidIt = true; //even if I write n or N, it will switch the value of iDidIt to Y 
//            break;
//        } while (doIt);

        
        while (doIt) {
        	iDidIt = true;//by switching the loop to a while, we are asking Java to read first the condition 
        	break;		  //this way it will evaluate first if doIt is true before changing the value of iDidIt
        }

        if (doIt && iDidIt) {
            System.out.println("I did it!");//if writing y
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");//if writing n
        }
    }
}