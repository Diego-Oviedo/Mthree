package com.sg.foundations.flowcontrol.whiles;

public class LovesMe {

	public static void main(String[] args) {
		
		int counter = 1;
		String lovesMe = "It LOVES me!";
		String lovesMeNot = "It loves me NOT!";
		boolean love = true;	
		
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
			
			
			counter ++;//count it as cut already
			
			
		}while (counter <= 34);//while 34 petals, go on and pick a new one

		
		if(!love) {//as the while is designed to change the value of the variable love after being read it, 
				  //the if must to read the opposite of the last response to march the last out put 
			System.out.println("It loved me, I knew it!! <3");
		}else if(love) {
			System.out.println("It never loved me, I knew it!! </3");
		}
		

	}

}
