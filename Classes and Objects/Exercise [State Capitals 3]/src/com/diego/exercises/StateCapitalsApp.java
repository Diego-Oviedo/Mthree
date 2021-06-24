package com.diego.exercises;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StateCapitalsApp {

	public static void main(String[] args) {
		
		
		Map<String, Capital> data_states = new HashMap<>();
		UserIO userIO = new UserIOImplementation();
		Capital capital;
		int counter = 0;
		
		try {
		      File file = new File("MoreStateCapitals.txt");
		      Scanner reader = new Scanner(file);
		      reader.useDelimiter("::");
		      
		      
		      while (reader.hasNextLine()) {
		    	
		    	  String state = reader.next();
		    	  String capital_name = reader.next();
		    	  int population = Integer.parseInt(reader.next());
		    	  String square_mileage_tmp = reader.nextLine();
		    	  capital = new Capital();
		    	  
		    	  square_mileage_tmp = square_mileage_tmp.substring(2,square_mileage_tmp.length());
		    	  
		    	  double square_mileage = Double.parseDouble(square_mileage_tmp);
		    	  
		    	  capital.setName(capital_name);
		    	  capital.setPopulation(population);
		    	  capital.setSquare_mileage(square_mileage);
		    	  
		    	  data_states.put(state, capital);
		    	  
		    	  counter++;
		      }
		      
		      reader.close();
		      
		    } catch (FileNotFoundException e) {
		    	userIO.print("An error occurred.");
		      e.printStackTrace();
		    }
		
		userIO.print(counter + " STATES & CAPITALS WERE LOADED.");
		
		
		
		
		
		System.out.println("\n==============================\nSTATES & ITS DATA\n==============================\n");
		
		Set <String> keys = data_states.keySet();
		
		
		for (String state : keys) {
			
			userIO.print(state + " - " + data_states.get(state).getName() + " | Pop: " + data_states.get(state).getPopulation() + " | Area: " + data_states.get(state).getSquare_mileage() + " sq mi");
		}
		
		int pop_min = userIO.readInt("\n\n----------------------------------------------------\nPlease enter the lower limit for capital city population:");
		
		
		userIO.print("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + pop_min + ":\n");
		
		for (String state : keys) {
			
			int pop = data_states.get(state).getPopulation();
			
			if(pop >= pop_min) {
			
			userIO.print(state + " - " + data_states.get(state).getName() + " | Pop: " + data_states.get(state).getPopulation() + " | Area: " + data_states.get(state).getSquare_mileage() + " sq mi");
			
			}
		}
		
		
		double sq_limit = userIO.readDouble("\n\n----------------------------------------------------\nPlease enter the upper limit for capital city sq mileage:");
		
		
		userIO.print("LISTING CAPITALS WITH AREAS LESS THAN " + pop_min + ":\n");
		
		for (String state : keys) {
			
			double sq = data_states.get(state).getSquare_mileage();
			
			if(sq <= sq_limit) {
			
			userIO.print(state + " - " + data_states.get(state).getName() + " | Pop: " + data_states.get(state).getPopulation() + " | Area: " + data_states.get(state).getSquare_mileage() + " sq mi");
			
			}
		}
		
		
	}

}
