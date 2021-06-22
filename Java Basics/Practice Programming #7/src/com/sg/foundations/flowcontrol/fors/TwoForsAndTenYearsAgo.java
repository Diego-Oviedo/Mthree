package com.sg.foundations.flowcontrol.fors;
import java.util.*;

public class TwoForsAndTenYearsAgo {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {//staring point is zero "i = 0"
        							  //the end point is 10 "i <= 10"
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

        //both loops are clear for me, firs
        
        
        for (int i = year; i >= year - 20; i--) {//staring point is the selected year "i = year"
			  									//the end point is the selected year minus 10 "year - 10"
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}