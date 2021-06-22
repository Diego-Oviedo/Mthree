package com.sg.foundations.flowcontrol.ifs;
import java.util.*;


public class FieldDay {
	
	public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in);
	String userName;
	
	
	System.out.println("Hi There, let's play a game!\n" + "Give me your name and I'll get your team name\n"
			+ "don't forget to hit enter to confirm your entry");

	userName = in.next();
	
	
	if (userName.compareTo("Baggins") < 0 ) { // before Baggins
		
		System.out.println(userName + "! your team is " + "Red Dragons");
		
	}else if (userName.compareTo("Baggins") > 0 && userName.compareTo("Dresden") < 0 ) { //after Baggins, but before Dresden
		
		System.out.println(userName + "! your team is " + "Dark Wizards");
		
	}else if (userName.compareTo("Dresden") > 0 && userName.compareTo("Howl") < 0 ) { //after Dresden, but before Howl
		
		System.out.println(userName + "! your team is " + "Moving Castles");
		
	}else if (userName.compareTo("Howl") > 0 && userName.compareTo("Potter") < 0 ) { //after Howl, but before Potter
		
		System.out.println(userName + "! your team is " + "Golden Snitches");
	}else if (userName.compareTo("Potter") > 0 && userName.compareTo("Vimes") < 0 ) { //after Potter, but before Vimes
		
		System.out.println(userName + "! your team is " + "Night Guards");
	}else if (userName.compareTo("Vimes") > 0) { //after Vimes
		
		System.out.println(userName + "! your team is " + "Black Hole");
	}
	
	
	
	
	}
}
