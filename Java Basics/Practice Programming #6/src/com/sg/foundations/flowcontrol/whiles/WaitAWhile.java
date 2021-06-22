package com.sg.foundations.flowcontrol.whiles;

public class WaitAWhile {

    public static void main(String[] args) {

        int timeNow = 5;
        int bedTime = 11;//if the time changes to 11, the loop will go a round further

        while (timeNow < bedTime) {// as this condition means, if the
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}