package com.sg.foundations.flowcontrol.random;
import java.util.*;

public class ALittleChaos {

	public static void main(String[] args) {
	    
	        Random randomizer = new Random();

	        System.out.println("Random can make integers: " + randomizer.nextInt());
	        System.out.println("Or a double: " + randomizer.nextDouble());
	        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

	        long num = randomizer.nextLong();// getting a random long 

	        System.out.println("You can store a randomized result: " + num);
	        System.out.println("And use it over and over again: " + num + ", " + num);

	        System.out.println("Or just keep generating new values");
	        System.out.println("Here's a bunch of numbers from 0 - 100: ");

	        System.out.println((randomizer.nextInt(51) + 50) + ", ");// This change will provide an random number between 0 and 50 and add 50
	        System.out.println("This is the result of a random number splited by 4: " +(randomizer.nextInt(101) /4 ));//adding the random number into a math statement
	        System.out.println("This is the result of asking a double random number: " +randomizer.nextDouble() + ",vs a random float: " + randomizer.nextFloat());
	        System.out.print(randomizer.nextInt(101) + ", ");
	        System.out.println(randomizer.nextInt(101));


	}

}
