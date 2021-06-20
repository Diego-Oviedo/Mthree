package com.sg.foundations.flowcontrol.fors;

public class ForAndTwentyBlackbirds {

	public static void main(String[] args) {
        int birdsInPie = 0;
        for (int i = 1; i <= 24; i++) { //change made so loop will stop once 24 birds counted...
        		//iterator was increased to be 1, this way the print will start from 1 and not 0
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }

}
