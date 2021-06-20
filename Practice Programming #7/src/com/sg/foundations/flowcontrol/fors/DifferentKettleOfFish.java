package com.sg.foundations.flowcontrol.fors;

public class DifferentKettleOfFish {
    public static void main(String[] args) {

        int fish = 1;
        while(fish <= 10){// to get the expected output, the condition should be an equal or less, instead of an less than condition
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }

            fish++;
        }

    }
}

