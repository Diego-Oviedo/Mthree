package com.sg.foundations.flowcontrol.arrays;

public class FruitSalad {

    public static void main(String[] args) {
        String[] fruits = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};

        String[] fruitSalad = saladMaker (fruits);
        
        for (String item :fruitSalad) {
        	System.out.println(item + " ");
        }


    }
    
    public static String [] saladMaker(String[] fruits) {
 	   	int apples = 0;
    	int berries = 0; 
    	int oranges = 0;
    	int tomatoes = 0;
    	int otherTypeOfFruits = 0;
    	int counter = 0;
    	String fruitSalad [] = new String [12];
    	
    	
    	for (String fruit : fruits ) {
    		
    		if(fruit.contains("Apple") && counter <= 11 && apples <= 3) {
    			
    			apples ++;
    			
    			fruitSalad [counter] = fruit;
    			
    			counter	++;
    		}else if(fruit.contains("Tomato")) {
    			
    			tomatoes ++;
    			
    		}else if(fruit.contains("berry") && counter <= 11) {
    			
    			berries ++;
    			
    			fruitSalad [counter] = fruit;
    			
    			counter	++;
    		}else if(fruit.contains("Orange") && counter <= 11 && oranges <= 2) {
    			
    			oranges ++;
    			
    			fruitSalad [counter] = fruit;
    			
    			counter	++;
    		}else if (counter <= 11 && !fruit.contains("Orange") && apples <= 3 && oranges <= 2 || counter <= 11 && !fruit.contains("berry") && apples <= 3 && oranges <= 2 || counter <= 11 && !fruit.contains("Apple") && apples <= 3 && oranges <= 2) {
    			
    			fruitSalad [counter] = fruit;
    			
    			counter	++;
    			
    		}
    		
    	}
    	
    	
		return fruitSalad;
 	   
 	   
    }
    
    
    
    
    
}
