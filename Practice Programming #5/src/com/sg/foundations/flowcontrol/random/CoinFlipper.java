package com.sg.foundations.flowcontrol.random;

import java.util.*;

public class CoinFlipper {

	public static void main(String[] args) {
		
		
		 Random coinToss = new Random();
		 
		 boolean tails = coinToss.nextBoolean();
		 
		 System.out.println("Ready, Set, Flip....!!");
		 
		 if(tails) {
			 
			 System.out.println("You got TAILS!");
			 
		 }else {
			 
			 System.out.println("You got HEADS!");
			 
		 }

	}

}
