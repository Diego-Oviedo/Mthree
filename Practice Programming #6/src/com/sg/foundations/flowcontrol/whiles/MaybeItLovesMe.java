package com.sg.foundations.flowcontrol.whiles;
import java.util.*;

public class MaybeItLovesMe {

	public static void main(String[] args) {
		
		int petals = 0, petals_counter = 1;
		String lovesMe = "It LOVES me!";
		String lovesMeNot = "It loves me NOT!";
		boolean love = true;	
		
		
		petals = new Random().nextInt(89+1);//choosing a random number between 0 and 89
		
		while (petals < 13) {
			
			petals = new Random().nextInt(89+1);// if the number of petal is less than 13 then get a new number;
	
		}
		
		System.out.println("\nPetals: " + petals + "\n");
		
		do {
			
			while (love) {//while there is love 
			
			System.out.println(lovesMe);
				break;
			}
			
			while (!love) {//while there is no love 
			System.out.println(lovesMeNot);
				break;
			}
			
			if(love) {
				love = false;// next value will be the opposite of the previous one 
			}else if(!love) {
				love = true;
			}
			
			
			petals_counter ++;//count it as cut already
			
			
		}while (petals_counter <= petals);//while 34 petals, go on and pick a new one

		
		if(!love) {//as the while is designed to change the value of the variable love after being read it, 
				  //the if must to read the opposite of the last response to march the last out put 
			System.out.println("Oh, wow! It really LOVES me!");
		}else if(love) {
			System.out.println("Awwww, bummer.");
		}

	}

}
