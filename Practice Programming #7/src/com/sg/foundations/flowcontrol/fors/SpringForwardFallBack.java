package com.sg.foundations.flowcontrol.fors;

public class SpringForwardFallBack {

    public static void main(String[] args) {

        System.out.println("It's Spring...!");//the initial start point for this loop is 0 and it loops up to 9
        for (int i = 0; i < 11; i++) {//the ideal solution to match the range for the second loop would be 
        								//changing the start point to 1 and the ending point to 11 (int i = 1; i < 11; i++)
        	//However the request is to change only one of them, so I would increases the end point to 1, so it will count up to 10 
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");//the initial start point for this loop is 10 and it loops down up to 1
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}
