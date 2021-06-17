package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;

public class KnockKnock {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        if(nameGuess.equals("Marty McFly")){ //the equals() method compares the value of the object while the == operator compares if the objects points to the same memory location
            System.out.println("Hey! That's right! I'm back!");// as Java is a case sensitive A won´t be the same as a, this is because both letters has different binary code   
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
        
        
        
        
    }
}