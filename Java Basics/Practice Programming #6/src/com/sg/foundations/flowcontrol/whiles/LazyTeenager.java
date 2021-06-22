package com.sg.foundations.flowcontrol.whiles;
import java.util.*;

public class LazyTeenager {

	public static void main(String[] args) {
		
		int chances = 0,timesAsked = 0, parentsRequest;
		
		chances = new Random().nextInt(100);//setting how many times the teen will be asked to clean its room 
		
		//chances = 10 ;		
		//System.out.println("***************\n" + "chances: " +chances+ "\n***************\n");
		
		
		do {
			
			timesAsked ++;
			
			if(timesAsked <= 6) {//if the times asked are less than 7, ask nicely
			
			parentsRequest = new Random().nextInt(3);// adding different ways to ask the teen to clean its room 
			switch (parentsRequest) {
			case 0:
				System.out.println("Hey, do you mind to do your room?" + "(X" + timesAsked +")");
				break;
			case 1:
				System.out.println("Coudl you please claen your room?" + "(X" + timesAsked +")");
				break;
			case 2:
				System.out.println("Please go and clean your room!!!!" + "(X" + timesAsked +")");
				break;
			case 3:
				System.out.println("Your room looks a bit durty, why don't you go and give it a good sweep!?" + "(X" + timesAsked +")");
				break;	
			}
			
			
			}else if (timesAsked == 7) {// on the 7th time the teen will be grounded 
				
				System.out.println("***************\n" +"This is the " + timesAsked +"th time I'm asking you to clean your room!");
				System.out.println("YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!"+ "\n***************");
				
			}else if(timesAsked >= 8) {//if the times asked are more than 7, ask roughly
				
				parentsRequest = new Random().nextInt(3);// adding different ways to ask the teen to clean its room 
				switch (parentsRequest) {
				case 0:
					System.out.println("GOD PLEASE! claen your room" + "(X" + timesAsked +")");
					break;
				case 1:
					System.out.println("GO CLEAN YOUR ROOM!" + "(X" + timesAsked +")");
					break;
				case 2:
					System.out.println("You are not leaving this house until you clean your room!!!" + "(X" + timesAsked +")");
					break;
				case 3:
					System.out.println("Don't make me call your father, go claen your room;" + "(X" + timesAsked +")");
					break;	
				}
				
				
				}
			
			
			
			
		}while (timesAsked < chances);//ask to clean the room until the chances get to 100% ore more, who knows maybe the teen gets motivated enough 
		
		
		
		if(timesAsked == chances) {
			System.out.println("FINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");	
		}
		
		
		
		
		
		
	}

}
