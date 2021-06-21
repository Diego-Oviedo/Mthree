package com.sg.foundations.flowcontrol.methods;
import java.util.*;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = getColor(); // call color method here
        String animal = getAnimal(); // call animal method again here
        String colorAgain = getColor(); // call color method again here
        int weight = getRandomNum(5,200); // call number method,
            // with a range between 5 - 200
        int distance = getRandomNum(10,20); // call number method,
            // with a range between 10 - 20
        int number = getRandomNum(10000,20000); // call number method,
            // with a range between 10000 - 20000
        int time = getRandomNum(2,6); // call number method,
            // with a range between 2 - 6            

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }

    static public String getColor() {
    	
    	String color;
    	
    	int x = new Random().nextInt(4);
    		if (x == 0) {
    			color = "Green";
    		}else if (x == 1) {
    			color = "Blue";
    		}else if (x == 2) {
    			color = "Brown";
    		}else if (x == 3) {
    			color = "Red";
    		}else if (x == 4) { 
    			color = "Yellow";
    		}else {
    			color = "Orange";
    		}
    	
    		return color;
    		
    }
    
    static public String getAnimal() {
    	
    	String animal;
    	
    	int x = new Random().nextInt(4);
    		if (x == 0) {
    			animal = "Shark";
    		}else if (x == 1) {
    			animal = "Bear";
    		}else if (x == 2) {
    			animal = "Turkey";
    		}else if (x == 3) {
    			animal = "Jellyfish";
    		}else if (x == 4) { 
    			animal = "Zebra";
    		}else {
    			animal = "Lion";
    		}
    	
    		return animal;		
    }
    
    
    static public int getRandomNum(int min,int max) {
    	
    	int result = new Random().nextInt((max -  min) + min );
    	
    	if (result == 0) {
    		result = 1;
    	}else {
    		result = result; 
    	}
    	
    	return result;

    }
}