package com.diego.excercises;

public class TestingUserIO {

	public static void main(String[] args) {
		UserIO userIO = new UserIOImplementation();
		
		double smallNum = userIO.readDouble("Give me a small number :");
	      double bigNum = userIO.readDouble("Now give me a much bigger number! :");
	      if(bigNum < smallNum){
	          userIO.print("Hey! " + smallNum +" is BIGGER than " + bigNum);
	          userIO.print("I guess I can fix it.");
	          double swapNum = bigNum;
	          bigNum = smallNum;
	          smallNum = swapNum;
	      }
	      double betweenNum = userIO.readDouble("Now give me one in between! : ", smallNum, bigNum);
	      userIO.print("I like the number "+betweenNum+"!");        
	    
	}

}
