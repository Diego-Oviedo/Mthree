package com.sg.foundations.flowcontrol.arrays;

public class FruitsBasket {

    public static void main(String[] args) {
        String[] fruitBasket = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple",
            "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Apple", "Banana", "Apple", "Orange",
            "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple",
            "Apple", "Apple", "Apple", "Orange", "Orange", "PawPaw", "Apple", "Orange",
            "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Apple", "Kiwi", "Orange", "Apple", "Orange",
            "Dragonfruit", "Apple", "Orange", "Orange"};

        int numOranges = 0;
        int numApples = 0;
        int numOtherFruit = 0;
        int totalFruits = 0;

        for (String fruit : fruitBasket) {
        	
        	if (fruit.equals("Orange")) {
        		
        		numOranges ++;
        		
        		totalFruits ++;
        		
        	}else if (fruit.equals("Apple")) {
        		
        		numApples ++;
        		
        		totalFruits ++;
        		
        	}else if (!fruit.equals("Apple") && !fruit.equals("Orange")) {
        		
        		numOtherFruit ++;
        		
        		totalFruits ++;
        	}
        }

        System.out.println("\nTotal of fruits in basket: " + totalFruits +"\n");
        System.out.println("Total of Oranges: " + numOranges + "\n");
        System.out.println("Total of Apples: " + numApples + "\n");
        System.out.println("Total of other fruits : " + numOtherFruit + "\n");

    }
}