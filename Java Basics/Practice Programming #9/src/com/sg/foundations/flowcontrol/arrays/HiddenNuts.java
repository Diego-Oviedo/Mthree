package com.sg.foundations.flowcontrol.arrays;
import java.util.*;

public class HiddenNuts {

    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");
        int position = 0;
        
       for (String finder : hidingSpots) {
    	   
    	   if (finder != null) {
    		   
    		   System.out.println("Found it! It's in spot# " + position);
    		   
    		   //System.out.println(hidingSpots[position]);
    		   
    	   }
    	   
    	   position ++;
    	  
       }
       
       
       
    	   
    }
}